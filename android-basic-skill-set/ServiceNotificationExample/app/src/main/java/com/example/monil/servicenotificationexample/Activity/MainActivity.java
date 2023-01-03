package com.example.monil.servicenotificationexample.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.monil.servicenotificationexample.R;
import com.example.monil.servicenotificationexample.Service.NotificationService;
import com.example.monil.servicenotificationexample.Utils.Constants;

public class MainActivity extends BaseActivity {

    private Button mStartBtn,mStopBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        prepareViews();
        setListeners();
    }

    @Override
    protected void initComponent() {

        mStartBtn=(Button)findViewById(R.id.StartService);
        mStopBtn=(Button)findViewById(R.id.StopService);
    }

    @Override
    protected void prepareViews() {

    }

    @Override
    protected void setListeners() {

        mStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(MainActivity.this, NotificationService.class));
            }
        });

        mStopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stopService(new Intent(MainActivity.this, NotificationService.class));
            }
        });
    }
}
