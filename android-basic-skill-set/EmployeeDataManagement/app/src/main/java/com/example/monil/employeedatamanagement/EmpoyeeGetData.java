package com.example.monil.employeedatamanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EmpoyeeGetData extends BaseActivity {

    ListView listView;
    ArrayList<EmployeeHelper> employeeHelpers = new ArrayList<EmployeeHelper>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empoyee_get_data);
        Intent i = this.getIntent();
        employeeHelpers = i.getParcelableArrayListExtra("employee");


        EmployeeAdapter adapter = new EmployeeAdapter(this, employeeHelpers);

        listView = (ListView) findViewById(R.id.lvEmployeeGet);
        listView.setAdapter(adapter);



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
}
