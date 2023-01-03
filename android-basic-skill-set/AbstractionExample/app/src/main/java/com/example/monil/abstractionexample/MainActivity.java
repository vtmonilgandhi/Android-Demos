package com.example.monil.abstractionexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Plan {
    EditText RateEdt, UnitEdt;
    Button ansBtn;
    TextView ansTv;
    String rate, unit;

    @Override
    public void getRate() {
        rate = RateEdt.getText().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RateEdt = (EditText) findViewById(R.id.RateEdt);
        UnitEdt = (EditText) findViewById(R.id.UnitEdt);
        ansBtn = (Button) findViewById(R.id.ansBtn);
        ansTv = (TextView) findViewById(R.id.ansTv);
        ansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unit = UnitEdt.getText().toString();
                getRate();
                calculateBill(Integer.parseInt(rate), Integer.parseInt(unit));
                ansTv.setText(String.valueOf(value));
            }
        });

    }
}
