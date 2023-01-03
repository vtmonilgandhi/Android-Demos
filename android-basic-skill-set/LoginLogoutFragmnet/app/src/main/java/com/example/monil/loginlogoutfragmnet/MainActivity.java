package com.example.monil.loginlogoutfragmnet;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends BaseActivity{

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

    }

    @Override
    protected void prepareViews() {

        FragmentManager fm = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fm.beginTransaction();
        FirstFragment fm1 = new FirstFragment();
        fragmentTransaction.add(R.id.frag_Container, fm1,"HELLO");
        fragmentTransaction.commit();

            }



    @Override
    protected void setListeners() {

    }


}
