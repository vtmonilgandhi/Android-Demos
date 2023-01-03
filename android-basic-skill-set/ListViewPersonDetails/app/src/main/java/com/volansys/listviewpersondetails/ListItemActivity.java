package com.volansys.listviewpersondetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ListItemActivity extends AppCompatActivity {

    TextView txtId;
    TextView txtName;
    TextView txtNumber;

    String id;
    String name;
    String number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        Intent i = getIntent();

        id = i.getStringExtra("id");

        name = i.getStringExtra("name");

        number = i.getStringExtra("number");


        txtId = (TextView) findViewById(R.id.idTV);
        txtName = (TextView) findViewById(R.id.nameTV);
        txtNumber = (TextView) findViewById(R.id.numberTV);


        txtId.setText(id);
        txtName.setText(name);
        txtNumber.setText(number);

    }
}
