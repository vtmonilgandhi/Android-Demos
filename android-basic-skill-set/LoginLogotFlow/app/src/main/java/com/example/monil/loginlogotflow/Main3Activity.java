package com.example.monil.loginlogotflow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends BaseActivity implements View.OnClickListener{
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initComponent();
        prepareViews();
        setListeners();
    }

    @Override
    protected void initComponent() {
        button3=(Button)findViewById(R.id.btn3);

    }

    @Override
    protected void prepareViews() {

    }

    @Override
    protected void setListeners() {
        button3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(Main3Activity.this,Main4Activity.class);
        startActivity(intent);

    }
}
