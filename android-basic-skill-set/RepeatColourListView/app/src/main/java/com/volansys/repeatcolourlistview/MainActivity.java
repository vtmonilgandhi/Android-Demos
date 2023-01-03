package com.volansys.repeatcolourlistview;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private ArrayList<Person> personList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PersonAdapter personAdapter;
    EditText editText;
    Button button;


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
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        editText=(EditText)findViewById(R.id.num);
        button=(Button)findViewById(R.id.btn);


    }

    @Override
    protected void prepareViews() {

    }

    @Override
    protected void setListeners() {
        button.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {

        int n= Integer.parseInt(editText.getText().toString());
        personList = new ArrayList<Person>();
        Person person = new Person("");



        for (int i = 0; i < n; i++) {
            personList.add(person);


            personAdapter = new PersonAdapter(personList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
            recyclerView.setAdapter(personAdapter);


        }

    }
}
