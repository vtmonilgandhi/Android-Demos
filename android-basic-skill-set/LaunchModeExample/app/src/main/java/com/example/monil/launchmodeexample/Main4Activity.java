package com.example.monil.launchmodeexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

    }
    public void launch(View view) {
        Intent intent = new Intent(Main4Activity.this,MainActivity.class);
        startActivity(intent);
    }

    public void launch_two(View view) {
        Intent intent = new Intent(Main4Activity.this,Main2Activity.class);
        startActivity(intent);
    }

    public void launch_one(View view) {
        Intent intent = new Intent(Main4Activity.this,Main3Activity.class);
        startActivity(intent);
    }
}
