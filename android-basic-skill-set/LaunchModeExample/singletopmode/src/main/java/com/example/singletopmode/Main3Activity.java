package com.example.singletopmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void launch(View view) {
        Intent intent = new Intent(Main3Activity.this,MainActivity.class);
        startActivity(intent);
    }

    public void launch_two(View view) {
        Intent intent = new Intent(Main3Activity.this,Main2Activity.class);
        startActivity(intent);
    }

    public void launch_one(View view) {
        Intent intent = new Intent(Main3Activity.this,Main4Activity.class);
        startActivity(intent);
    }
}
