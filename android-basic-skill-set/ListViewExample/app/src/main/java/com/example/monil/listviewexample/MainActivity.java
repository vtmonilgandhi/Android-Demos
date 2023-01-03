package com.example.monil.listviewexample;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {

   private ListView listView;


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

        listView = (ListView) findViewById(R.id.Fruit_list);


    }

    @Override
    protected void prepareViews() {

    }

    @Override
    protected void setListeners() {

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(getApplicationContext(),listView.getItemAtPosition(i).toString()
                , Toast.LENGTH_SHORT).show();

    }
}
