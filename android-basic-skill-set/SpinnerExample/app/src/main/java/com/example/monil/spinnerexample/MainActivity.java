package com.example.monil.spinnerexample;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;



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

        spinner = (Spinner) findViewById(R.id.spinnerFruit);



    }

    @Override
    protected void prepareViews() {

    }

    @Override
    protected void setListeners() {

        spinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(MainActivity.this,String.valueOf(spinner.getSelectedItem()),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
