package com.example.singletaskmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launch(View view) {
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }

    public void launch_two(View view) {
        Intent intent = new Intent(MainActivity.this,Main3Activity.class);
        startActivity(intent);
    }

    public void launch_one(View view) {
        Intent intent = new Intent(MainActivity.this,Main4Activity.class);
        startActivity(intent);
    }
}
