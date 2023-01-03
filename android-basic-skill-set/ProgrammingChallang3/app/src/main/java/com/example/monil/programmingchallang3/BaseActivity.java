package com.example.monil.programmingchallang3;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Volansys on 02/01/2018.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected abstract void initComponent();
    protected abstract void prepareViews();
    protected abstract void setListeners();
}
