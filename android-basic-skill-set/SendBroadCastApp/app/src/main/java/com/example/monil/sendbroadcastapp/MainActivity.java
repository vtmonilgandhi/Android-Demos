package com.example.monil.sendbroadcastapp;

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

public class MainActivity extends AppCompatActivity {
    Button ansBtn;
    TextView msgTv;
    private BroadcastReceiver message = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            Double speed_received = intent.getDoubleExtra("current speed", 10);
            Double latittude_received = intent.getDoubleExtra("latitude", 0);
            Double longitude_received = intent.getDoubleExtra("longitude", 0);

            TextView speed = (TextView) findViewById(R.id.textView1);
            speed.setText("speed :    " + speed_received);

            TextView latitude = (TextView) findViewById(R.id.textView2);
            latitude.setText("latitude :   " + latittude_received);

            TextView longitude = (TextView) findViewById(R.id.textView3);
            longitude.setText("longitude :    " + longitude_received);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ansBtn = (Button) findViewById(R.id.ansBtn);
        msgTv = (TextView) findViewById(R.id.ansTv);
        LocalBroadcastManager.getInstance(this).registerReceiver(
                message, new IntentFilter("send"));
        Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startService(new Intent(MainActivity.this, SendDataService.class));

            }
        });

        ansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent();
                intent.setAction("com.pkg.perform.Ruby");
                intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                // intent.setComponent(new ComponentName("com.example.monil.receivebroadcastapp", "com.example.monil.receivebroadcastapp.MainActivity"));
                sendBroadcast(intent);
                msgTv.setText("Broadcast is sent");
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(message);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(message,
                new IntentFilter("send"));
    }

}

