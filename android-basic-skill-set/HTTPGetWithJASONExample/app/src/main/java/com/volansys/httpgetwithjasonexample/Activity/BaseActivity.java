package com.volansys.httpgetwithjasonexample.Activity;

import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract void initComponent();
    protected abstract void prepareViews();
    protected abstract void setListeners();

}
