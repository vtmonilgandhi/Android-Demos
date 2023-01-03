package com.example.monil.loginlogotflow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends BaseActivity implements View.OnClickListener{
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initComponent();
        prepareViews();
        setListeners();
    }

    @Override
    protected void initComponent() {
        button4=(Button)findViewById(R.id.btn4);

    }

    @Override
    protected void prepareViews() {

    }

    @Override
    protected void setListeners() {
    button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(Main4Activity.this,MainActivity.class);
        startActivity(intent);
        finishAffinity();

    }

}
