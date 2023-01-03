package com.volansys.spinnerpersondetails;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {

    ArrayList<Person> personArrayList;
    Spinner id, name, number;
    TextView idTvs;
    TextView nameTvs;
    TextView numberTvs;
    String s1, s2, s3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personArrayList = new ArrayList<Person>();
        Person person = new Person("1", "monil", "9428363728");
        Person person1 = new Person("2", "ridham", "8752413258");
        Person person2 = new Person("3", "bhavik", "7854124578");
        Person person3 = new Person("4", "ronak", "9542136958");
        Person person4 = new Person("5", "purvesh", "9876543218");

        personArrayList.add(person);
        personArrayList.add(person1);
        personArrayList.add(person2);
        personArrayList.add(person3);
        personArrayList.add(person4);


        initComponent();
        prepareViews();
        setListeners();

    }

    @Override
    protected void initComponent() {

        idTvs = (TextView) findViewById(R.id.idTV);
        nameTvs = (TextView) findViewById(R.id.nameTV);
        numberTvs = (TextView) findViewById(R.id.numberTV);
        id = (Spinner) findViewById(R.id.spinnerId);
        id.setAdapter(new PersonAdapter(this, 0, personArrayList));
        name = (Spinner) findViewById(R.id.spinnerName);
        name.setAdapter(new PersonAdapter(this, 1, personArrayList));
        number = (Spinner) findViewById(R.id.spinnerNumber);
        number.setAdapter(new PersonAdapter(this, 2, personArrayList));

    }

    @Override
    protected void prepareViews() {

    }

    @Override
    protected void setListeners() {

        id.setOnItemSelectedListener(this);
        name.setOnItemSelectedListener(this);
        number.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


        switch (adapterView.getId()) {
            case R.id.spinnerId:
                s1 = ((Person) id.getSelectedItem()).getId();
                ;
                idTvs.setText(s1);
                break;
            case R.id.spinnerName:
                s2 = ((Person) id.getSelectedItem()).getName();
                nameTvs.setText(s2);
                break;
            case R.id.spinnerNumber:
                s3 = personArrayList.get(i).getNumber();
                numberTvs.setText(s3);
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
