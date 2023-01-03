package com.example.monil.servicedemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button startButton,stopButton,startActivityBtn;
    MyService mBoundService;
    boolean mServiceBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton= findViewById(R.id.start_button);
        stopButton= findViewById(R.id.stop_button);
        startActivityBtn=findViewById(R.id.startActivityBtn);

        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        startActivityBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent=new Intent(this,MyService.class);

        switch (v.getId())
        {
            case R.id.start_button:
                startService(intent);
                bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
                break;
            case R.id.stop_button:
                if (mServiceBound) {
                    unbindService(mServiceConnection);
                    mServiceBound = false;
                }
                stopService(intent);
                break;
            case R.id.startActivityBtn:
                Intent intent1 =new Intent(MainActivity.this,DemoActivity.class);
                startActivity(intent1);
        }

    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBound = false;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyBinder myBinder = (MyService.MyBinder) service;
            mBoundService = myBinder.getService();
            mServiceBound = true;
        }
    };
}