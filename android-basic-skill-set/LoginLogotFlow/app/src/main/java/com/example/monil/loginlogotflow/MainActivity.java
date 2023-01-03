package com.example.monil.loginlogotflow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
        prepareViews();
        setListeners();

    }

    @Override
    protected void initComponent() {
        button=(Button)findViewById(R.id.btn1);

    }

    @Override
    protected void prepareViews() {

    }

    @Override
    protected void setListeners() {
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);

    }

}
