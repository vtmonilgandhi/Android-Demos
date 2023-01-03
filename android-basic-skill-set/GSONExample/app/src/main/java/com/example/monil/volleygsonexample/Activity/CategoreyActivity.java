package com.example.monil.volleygsonexample.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.monil.volleygsonexample.R;

public class CategoreyActivity extends AppCompatActivity {
    Button DepartmentBtn, EmployeesBtn, ClientsBtn, CEOBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorey);
        DepartmentBtn = (Button) findViewById(R.id.departmentBtn);
        EmployeesBtn = (Button) findViewById(R.id.employeesBtn);
        ClientsBtn = (Button) findViewById(R.id.cilentBtn);
        CEOBtn = (Button) findViewById(R.id.CEOBtn);

        DepartmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(CategoreyActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        EmployeesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(CategoreyActivity.this,EmployeeActivity.class);
                startActivity(intent);
            }
        });
        ClientsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(CategoreyActivity.this,ClientsActivity.class);
                startActivity(intent);
            }
        });
        CEOBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(CategoreyActivity.this,CEODeatilsActivity.class);
                startActivity(intent);
            }
        });

    }
}
