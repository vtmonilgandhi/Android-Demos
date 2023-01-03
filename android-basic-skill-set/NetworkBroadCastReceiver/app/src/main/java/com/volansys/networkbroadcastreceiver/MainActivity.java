package com.volansys.networkbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        IntentFilter screenStateFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
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

    public class BroadcastScreenReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent arg1) {

            boolean isConnected = arg1.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            if(isConnected){
                Toast.makeText(context, "Internet Connection Lost", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(context, "Internet Connected", Toast.LENGTH_LONG).show();
            }
        }
    }
}
