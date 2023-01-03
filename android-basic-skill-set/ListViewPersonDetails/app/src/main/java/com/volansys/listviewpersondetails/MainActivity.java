package com.volansys.listviewpersondetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    ArrayList<Person> personArrayList;
    ListView personListView;


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
        personListView = (ListView) findViewById(R.id.PesonLv);
        personListView.setAdapter(new PersonAdapter(MainActivity.this, personArrayList));

    }

    @Override
    protected void prepareViews() {

    }

    @Override
    protected void setListeners() {

        personListView.setOnItemClickListener(this);

    }

  /*  @Override
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
*/


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {



        Intent i = new Intent(MainActivity.this, ListItemActivity.class);

        i.putExtra("id", personArrayList.get(position).getId());
        i.putExtra("name", personArrayList.get(position).getName());
        i.putExtra("number", personArrayList.get(position).getNumber());
        startActivity(i);

    }
}
