package com.example.singleinstancemode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void launch(View view) {
        Intent intent = new Intent(Main2Activity.this,MainActivity.class);
        startActivity(intent);
    }

    public void launch_two(View view) {
        Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
        startActivity(intent);
    }

    public void launch_one(View view) {
        Intent intent = new Intent(Main2Activity.this,Main4Activity.class);
        startActivity(intent);
    }
}
