package com.example.monil.compilepolymorphism;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button ansBtn;
    TextView ans1Tv, ans2Tv, ans3Tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ansBtn = (Button) findViewById(R.id.ansBtn);
        ans1Tv = (TextView) findViewById(R.id.ans1Tv);
        ans2Tv = (TextView) findViewById(R.id.ans2Tv);
        ans3Tv = (TextView) findViewById(R.id.ans3Tv);

        ansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ans1Tv.setText(String.valueOf(add(2, 3)));
                ans2Tv.setText(String.valueOf(add(2, 3, 4)));
                ans3Tv.setText(String.valueOf(add(2, 3.5)));
            }
        });

    }

    public int add(int m, int n) {

        return m + n;
    }

    public int add(int m, int n, int o) {

        return m + n + o;
    }

    public int add(int m, double n) {

        return m + (int) n;
    }


}
