package com.example.monil.fragmentcommunication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements FragmentOne.buttonPress {

    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;
    private LinearLayout layout1, layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout1 = (LinearLayout) findViewById(R.id.layout1);
        layout2 = (LinearLayout) findViewById(R.id.layout2);

        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();
        fragmentOne.setPress(this);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.layout1, fragmentOne);
        fragmentTransaction.replace(R.id.layout2, fragmentTwo);
        fragmentTransaction.commit();
    }

    @Override
    public void getTextData(String inputText) {

        fragmentTwo.dataTv.setText(inputText);
    }
}
