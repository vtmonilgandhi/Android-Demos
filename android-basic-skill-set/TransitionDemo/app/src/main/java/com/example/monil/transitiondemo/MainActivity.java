package com.example.monil.transitiondemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ImageSwitcher(View view) {
        Intent intent =new Intent(MainActivity.this,ImageSwitcherActivity.class);
        startActivity(intent);
    }

    public void ViewFliper(View view) {
        Intent intent =new Intent(MainActivity.this,ViewFlipperActivity.class);
        startActivity(intent);
    }

    public void ViewSwitcher(View view) {
        Intent intent =new Intent(MainActivity.this,ViewSwitcherActivity.class);
        startActivity(intent);
    }
}
