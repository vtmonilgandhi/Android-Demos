package com.volansys.programmingchallange6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText num1;
    TextView ans;
    int s1, s2;
    Button btn;

    public static boolean is_Prime(int n) {
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

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
        int sum = 1;
        int ctr = 0;
        int n = 0;

        while (ctr < s1) {
            n++;
            if (n % 2 != 0) {
                if (is_Prime(n)) {
                    sum += n;
                    ctr++;
                }
            }
        }
        ans.setText(Integer.toString(sum));

    }
}





