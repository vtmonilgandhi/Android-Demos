package com.example.monil.programmingchallenge1;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Volansys on 28/12/17.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected abstract void initComponent();
    protected abstract void prepareViews();
    protected abstract void setListeners();
}
