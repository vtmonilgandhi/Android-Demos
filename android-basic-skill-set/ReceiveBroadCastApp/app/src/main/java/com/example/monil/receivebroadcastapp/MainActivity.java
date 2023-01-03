package com.example.monil.receivebroadcastapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyBroadcastReceiver myBroadcastReceiver;
    TextView msgTv;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgTv = (TextView) findViewById(R.id.ansTv);
        myBroadcastReceiver = new MyBroadcastReceiver();
        intentFilter = new IntentFilter("com.pkg.perform.Ruby");


    }
    @Override
    protected void onResume() {
        super.onResume();

        registerReceiver(myBroadcastReceiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (myBroadcastReceiver != null)
            unregisterReceiver(myBroadcastReceiver);
        ;
    }

    public class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            msgTv.setText("Data Received from External App");
            Toast.makeText(MainActivity.this, "Data Received from External App", Toast.LENGTH_SHORT).show();

        }

    }
}