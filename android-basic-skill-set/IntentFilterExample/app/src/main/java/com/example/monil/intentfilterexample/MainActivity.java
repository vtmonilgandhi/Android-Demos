package com.example.monil.intentfilterexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    Button play, camera, messanger, message, dialer;

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
        play = (Button) findViewById(R.id.playBtn);
        dialer = (Button) findViewById(R.id.dialBtn);
        messanger = (Button) findViewById(R.id.messangerBtn);
        camera = (Button) findViewById(R.id.cameraBtn);
        message = (Button) findViewById(R.id.messageBtn);


    }

    @Override
    protected void prepareViews() {

    }

    @Override
    protected void setListeners() {
        play.setOnClickListener(this);
        dialer.setOnClickListener(this);
        messanger.setOnClickListener(this);
        camera.setOnClickListener(this);
        message.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.dialBtn:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
                break;
            case R.id.playBtn:
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("https://play.google.com"));
                startActivity(intent1);
                break;
            case R.id.messangerBtn:
                Intent intent2 = new Intent(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse("sms:"));
                startActivity(intent2);
                break;
            case R.id.cameraBtn:
                Intent intent3 = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent3);
                break;
            case R.id.messageBtn:
                Intent intent4 = new Intent(Intent.ACTION_VIEW);
                intent4.setData(Uri.parse("sms:"));
                intent4.putExtra("sms_body", "This message is from monil gandhi.");
                startActivity(intent4);
                break;

        }
    }
}
