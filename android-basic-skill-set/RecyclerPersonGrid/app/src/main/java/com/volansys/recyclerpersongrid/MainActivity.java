package com.volansys.recyclerpersongrid;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private ArrayList<Person> personList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PersonAdapter personAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personList = new ArrayList<Person>();
        Person person = new Person("1", "monil", "9428363728");
        Person person1 = new Person("2", "ridham", "8752413258");
        Person person2 = new Person("3", "bhavik", "7854124578");
        Person person3 = new Person("4", "ronak", "9542136958");
        Person person4 = new Person("5", "purvesh", "9876543218");

        personList.add(person);
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        initComponent();
        prepareViews();
        setListeners();


        personAdapter = new PersonAdapter(personList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(personAdapter);

    }

    @Override
    protected void initComponent() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


    }

    @Override
    protected void prepareViews() {

    }

    @Override
    protected void setListeners() {


    }


}
