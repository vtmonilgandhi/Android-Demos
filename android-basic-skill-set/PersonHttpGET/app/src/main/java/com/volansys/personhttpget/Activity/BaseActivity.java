package com.volansys.personhttpget.Activity;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Volansys on 3/1/18.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected abstract void initComponent();
    protected abstract void prepareViews();
    protected abstract void setListeners();
}
