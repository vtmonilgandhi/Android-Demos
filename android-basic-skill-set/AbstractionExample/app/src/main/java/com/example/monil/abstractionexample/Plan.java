package com.example.monil.abstractionexample;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Volansys on 12/2/18.
 */
abstract class Plan extends AppCompatActivity {

    public int value;

    public abstract void getRate();

    public void calculateBill(int units, int rate) {
        value = rate * units;
    }
}
