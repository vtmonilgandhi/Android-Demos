package com.volansys.checkboxlistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    ArrayList<Person> personArrayList;
    ListView personListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personArrayList = new ArrayList<Person>();
        Person person = new Person("monil");
        personArrayList.add(person);
        Person person1 = new Person( "ridham");
        personArrayList.add(person1);
        Person person2 = new Person("bhavik");
        personArrayList.add(person2);
        Person person3 = new Person("ronak");
        personArrayList.add(person3);
        Person person4 = new Person("purvesh");
        personArrayList.add(person4);
        Person person5 = new Person("raj");
        personArrayList.add(person5);
        Person person6 = new Person( "ritvik");
        personArrayList.add(person6);
        Person person7 = new Person("paresh");
        personArrayList.add(person7);
        Person person8 = new Person("jiya");
        personArrayList.add(person8);
        Person person9 = new Person("manju");
        personArrayList.add(person9);
        Person person10 = new Person("charmi");
        personArrayList.add(person10);
        Person person11 = new Person( "tejas");
        personArrayList.add(person11);
        Person person12 = new Person("chintu");
        personArrayList.add(person12);
        Person person13 = new Person("mayank");
        personArrayList.add(person13);
        Person person14 = new Person("mona");
        personArrayList.add(person14);
        Person person15 = new Person("kamini");
        personArrayList.add(person15);
        Person person16 = new Person( "shreya");
        personArrayList.add(person16);
        Person person17 = new Person("pinal");
        personArrayList.add(person17);
        Person person18 = new Person("rajesh");
        personArrayList.add(person18);
        Person person19 = new Person("vicky");
        personArrayList.add(person19);



        initComponent();
        prepareViews();
        setListeners();

    }

    @Override
    protected void initComponent() {
        personListView = (ListView) findViewById(R.id.checkList);
        personListView.setAdapter(new PersonAdapter(MainActivity.this, personArrayList));

    }

    @Override
    protected void prepareViews() {

    }

    @Override
    protected void setListeners() {


    }

}
