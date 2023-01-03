package com.example.monil.gridviewexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends BaseActivity {


    GridView gridview ;
    String[] textoList;


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

             textoList = getResources().getStringArray(R.array.arrays);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,textoList);
        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(ad);



    }

    @Override
    protected void prepareViews() {

    }

    @Override
    protected void setListeners() {

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                Toast.makeText(getApplicationContext(),gridview.getItemAtPosition(arg2).toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}
