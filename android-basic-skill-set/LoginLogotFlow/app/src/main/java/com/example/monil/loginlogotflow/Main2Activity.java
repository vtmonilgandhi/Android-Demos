package com.example.monil.loginlogotflow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends BaseActivity implements View.OnClickListener {

    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initComponent();
        prepareViews();
        setListeners();
    }

    @Override
    protected void initComponent() {
        button2=(Button)findViewById(R.id.btn2);

    }

    @Override
    protected void prepareViews() {

    }

    @Override
    protected void setListeners() {
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
        startActivity(intent);

    }
}
