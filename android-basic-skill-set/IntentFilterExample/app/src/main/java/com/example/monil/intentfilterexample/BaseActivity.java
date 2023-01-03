package com.example.monil.intentfilterexample;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Volansys on 02/01/18.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected abstract void initComponent();
    protected abstract void prepareViews();
    protected abstract void setListeners();

}
