package com.example.monil.programmingchallang3;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    int num1 = 13, num2 = 20, base = 23;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if ((num1 > base) && (num2 > base)) {
            if ((num1 - base) > (num2 - base))

            {
                System.out.println("Nearest to base :" + num2);
            } else {
                System.out.println("Nearest to base :" + num1);
            }
        } else if ((num1 < base) && (num2 < base)) {
            if ((base - num1) > (base - num2))

            {
                System.out.println("Nearest to base :" + num2);
            } else {
                System.out.println("Nearest to base :" + num1);
            }
        } else if ((num1 > base) && (num2 < base)) {
            if ((num1 - base) > (base - num2))

            {
                System.out.println("Nearest to base :" + num2);
            } else {
                System.out.println("Nearest to base :" + num1);
            }
        } else if ((num1 < base) && (num2 > base)) {
            if ((base - num1) > (num2 - base))

            {
                System.out.println("Nearest to base :" + num2);
            } else {
                System.out.println("Nearest to base :" + num1);
            }
        }

        initComponent();
        prepareViews();
        setListeners();


    }

    @Override
    protected void initComponent() {

    }

    @Override
    protected void prepareViews() {


    }

    @Override
    protected void setListeners() {


    }

    @Override
    public void onClick(View view) {


    }
}
