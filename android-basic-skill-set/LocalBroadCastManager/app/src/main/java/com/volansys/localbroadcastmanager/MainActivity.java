package com.volansys.localbroadcastmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private Button mButtonSend;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mContext = getApplicationContext();


        LocalBroadcastManager.getInstance(mContext).registerReceiver(
                mRandomNumberReceiver,
                new IntentFilter("android.intent.action.MAIN")
        );


        mButtonSend = (Button) findViewById(R.id.btn_send);


        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name = getLocalClassName().toString();


                Intent intent = new Intent("android.intent.action.MAIN");

                intent.putExtra("Name", Name);


                LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);

            }
        });
    }

    private BroadcastReceiver mRandomNumberReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String receivedName = intent.getStringExtra("Name");


            Toast.makeText(context, "Received : " + receivedName, Toast.LENGTH_SHORT).show();
        }
    };
}