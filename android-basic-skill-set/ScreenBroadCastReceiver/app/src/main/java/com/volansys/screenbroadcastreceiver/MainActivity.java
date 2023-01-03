package com.volansys.screenbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BroadcastScreenReceiver mBroadcastScreenReceiver;
    private IntentFilter mIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Register
        mBroadcastScreenReceiver = new BroadcastScreenReceiver();
        IntentFilter screenStateFilter = new IntentFilter();
        screenStateFilter.addAction(Intent.ACTION_SCREEN_ON);
        screenStateFilter.addAction(Intent.ACTION_SCREEN_OFF);

        mIntentFilter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        registerReceiver(mBroadcastScreenReceiver, screenStateFilter);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        // Unregister
        if (mBroadcastScreenReceiver != null) {
            unregisterReceiver(mBroadcastScreenReceiver);
        }
    }

    private class BroadcastScreenReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
                Log.i("Check","Screen went OFF");
                Toast.makeText(context, "screen OFF",Toast.LENGTH_LONG).show();
            } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
                Log.i("Check","Screen went ON");
                Toast.makeText(context, "screen ON",Toast.LENGTH_LONG).show();
            }
        }
    }
}
