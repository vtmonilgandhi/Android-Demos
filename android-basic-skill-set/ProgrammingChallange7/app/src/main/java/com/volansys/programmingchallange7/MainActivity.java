package com.volansys.programmingchallange7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText num1;
    TextView ans;
    int s1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (EditText) findViewById(R.id.num1Edt);
        btn = (Button) findViewById(R.id.btn);
        ans = (TextView) findViewById(R.id.andTv);
        btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        s1 = Integer.parseInt(num1.getText().toString());


        int result = 0;
        int orig = s1;
        while (s1 != 0) {
            int remainder = s1 % 10;
            result = result + remainder * remainder * remainder;
            s1 = s1 / 10;
        }

        if (orig == result) {
            ans.setText("Given Number is armstrong numbre");
        } else ans.setText("Given Number is not armstrong numbre");

    }
}



