package com.example.monil.interfaceexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Rectangle {
    EditText WidthEdt, HeightEdt;
    Button ansBtn;
    TextView msgTv, ansTv;
    String width, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WidthEdt = (EditText) findViewById(R.id.WidthEdt);
        HeightEdt = (EditText) findViewById(R.id.HeightEdt);
        ansBtn = (Button) findViewById(R.id.ansBtn);
        msgTv = (TextView) findViewById(R.id.msgTv);
        ansTv = (TextView) findViewById(R.id.ansTv);
        ansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                width = WidthEdt.getText().toString();
                height = HeightEdt.getText().toString();
                msgTv.setText(draw());
                ansTv.setText(msg + String.valueOf(getArea(Double.parseDouble(width), Double.parseDouble(height))));
            }
        });

    }
}

