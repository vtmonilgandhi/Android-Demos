package com.example.monil.runpolymorphism;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button ansBtn;
    TextView ans1Tv, ans2Tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ansBtn = (Button) findViewById(R.id.ansBtn);
        ans1Tv = (TextView) findViewById(R.id.ans1Tv);
        ans2Tv = (TextView) findViewById(R.id.ans2Tv);

        ansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Vehicle v = new Bike();
                Vehicle v1 = new Vehicle();
                ans1Tv.setText(v.move());
                ans2Tv.setText(v1.move());
            }
        });

    }
}
