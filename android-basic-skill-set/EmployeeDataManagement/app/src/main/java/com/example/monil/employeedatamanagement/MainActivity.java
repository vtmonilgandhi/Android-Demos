package com.example.monil.employeedatamanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    ListView listView;
    Button button;
    ArrayList<EmployeeHelper> employeeHelpers = new ArrayList<EmployeeHelper>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        EmployeeAdapter adapter = new EmployeeAdapter(this, employeeHelpers);
        listView = (ListView) findViewById(R.id.lvEmployee);
        listView.setAdapter(adapter);

        EmployeeHelper employeeHelper = new EmployeeHelper("1","Monil","Intern","18000");
        EmployeeHelper employeeHelper1 = new EmployeeHelper("2","Urvish","Intern","18000");
        EmployeeHelper employeeHelper2 = new EmployeeHelper("3","Jay","Intern","18000");

        adapter.add(employeeHelper);
        adapter.add(employeeHelper1);
        adapter.add(employeeHelper2);



        initComponent();
        prepareViews();
        setListeners();

    }

    @Override
    protected void initComponent() {
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

        Intent i = new Intent(MainActivity.this, EmpoyeeGetData.class);
        i.putParcelableArrayListExtra("employee", employeeHelpers);
        this.startActivity(i);


    }
}
