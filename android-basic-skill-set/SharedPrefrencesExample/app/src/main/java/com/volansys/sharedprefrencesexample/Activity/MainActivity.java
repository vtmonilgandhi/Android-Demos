package com.volansys.sharedprefrencesexample.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.volansys.sharedprefrencesexample.R;
import com.volansys.sharedprefrencesexample.Utils.AppConstants;

public class MainActivity extends BaseActivity {

    EditText nameEdt, passEdt, emailEdt;
    Button saveBtn;
    SharedPreferences sharedpreferences;

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
        nameEdt = (EditText) findViewById(R.id.nameEdt);
        passEdt = (EditText) findViewById(R.id.passEdt);
        emailEdt = (EditText) findViewById(R.id.emailEdt);
        saveBtn = (Button) findViewById(R.id.saveBtn);
        sharedpreferences = getSharedPreferences(AppConstants.KEY_MYPREFERENCES, Context.MODE_PRIVATE);

    }

    @Override
    protected void prepareViews() {

    }

    @Override
    protected void setListeners() {
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEdt.getText().toString();
                String phone = passEdt.getText().toString();
                String email = emailEdt.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(AppConstants.KEY_NAME, name);
                editor.putString(AppConstants.KEY_PHONE, phone);
                editor.putString(AppConstants.KEY_EMAIL, email);
                editor.commit();
                Toast.makeText(MainActivity.this, AppConstants.KEY_MASSAGE, Toast.LENGTH_LONG).show();
            }
        });
    }
}
