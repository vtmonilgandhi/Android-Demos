package com.volansys.programmingchallange5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText num1, num2;
    TextView ans;
    int s1, s2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (EditText) findViewById(R.id.num1Edt);
        num2 = (EditText) findViewById(R.id.num2Edt);
        btn = (Button) findViewById(R.id.btn);
        ans = (TextView) findViewById(R.id.andTv);
        btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        s1 = Integer.parseInt(num1.getText().toString());
        s2 = Integer.parseInt(num2.getText().toString());

        int divided = s1 / s2;
        int result = s1 - (divided * s2);
   ans.setText(Integer.toString(result));
    }
}
