package com.example.monil.trainingproject2;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

public class MainActivity extends BaseActivity implements MessageFragment.buttonPress {


    TextView txt = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initComponent();
        prepareViews();
        setListeners();


    }

    @Override
    public void getTextData(String inputText) {

        txt.setText(inputText);
    }


    @Override
    protected void initComponent() {
        txt = (TextView) findViewById(R.id.textView);


    }

    @Override
    protected void prepareViews() {

        MessageFragment messageFragment=new MessageFragment();
        messageFragment.setPress(this);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frag_message, messageFragment);
        ft.commit();


    }

    @Override
    protected void setListeners() {

    }
}
