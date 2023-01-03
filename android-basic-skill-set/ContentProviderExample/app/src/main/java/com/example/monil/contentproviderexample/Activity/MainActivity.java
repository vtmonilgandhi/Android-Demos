package com.example.monil.contentproviderexample.Activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.monil.contentproviderexample.Provider.StudentsProvider;
import com.example.monil.contentproviderexample.R;
import com.example.monil.contentproviderexample.Utils.AppConstants;

public class MainActivity extends BaseActivity {
    private Button addBtn, retriveBtn;
    private EditText nameEdt,gradeEdt;

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

        addBtn = (Button) findViewById(R.id.btn_add);
        retriveBtn = (Button) findViewById(R.id.btn_retrive);
        nameEdt=(EditText) findViewById(R.id.input_name);
        gradeEdt=(EditText) findViewById(R.id.input_grade);
    }

    @Override
    protected void prepareViews() {

    }

    @Override
    protected void setListeners() {
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put(AppConstants.NAME,nameEdt.getText().toString());

                values.put(AppConstants.GRADE,gradeEdt.getText().toString());

                Uri uri = getContentResolver().insert(AppConstants.CONTENT_URI, values);

                Toast.makeText(getBaseContext(),uri.toString(), Toast.LENGTH_LONG).show();
            }
        });

        retriveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri students = Uri.parse(AppConstants.GET_DATA_URL);
                Cursor c = getContentResolver().query(students, null, null, null, AppConstants.NAME);

                if (c.moveToFirst()) {
                    do {
                        Toast.makeText(MainActivity.this,
                                c.getString(c.getColumnIndex(AppConstants._ID)) +
                                        ", " + c.getString(c.getColumnIndex(AppConstants.NAME)) +
                                        ", " + c.getString(c.getColumnIndex(AppConstants.GRADE)),
                                Toast.LENGTH_SHORT).show();
                    } while (c.moveToNext());
                }
            }
        });
    }
}
