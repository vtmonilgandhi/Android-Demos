package com.volansys.dialogexample;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button progress, alert, datePicker, timePicker, listDialog, customdialog;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private String[] fruit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fruit = getResources().getStringArray(R.array.Fruit);

        initComponent();
        prepareViews();
        setListeners();

    }

    @Override
    protected void initComponent() {

        progress = (Button) findViewById(R.id.ProgressBtn);
        alert = (Button) findViewById(R.id.AlertBtn);
        datePicker = (Button) findViewById(R.id.DateBtn);
        timePicker = (Button) findViewById(R.id.TimeBtn);
        listDialog = (Button) findViewById(R.id.ListBtn);
        customdialog = (Button) findViewById(R.id.CustomBtn);


    }

    @Override
    protected void prepareViews() {

    }

    @Override
    protected void setListeners() {

        progress.setOnClickListener(this);
        alert.setOnClickListener(this);
        datePicker.setOnClickListener(this);
        timePicker.setOnClickListener(this);
        listDialog.setOnClickListener(this);
        customdialog.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        switch (view.getId()) {

            case R.id.ProgressBtn:
                final ProgressDialog dialog = ProgressDialog.show(this, "Doing something", "Please wait....", true);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                            dialog.dismiss();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }).start();
                break;

            case R.id.AlertBtn:

                builder.setTitle("Sample Alert");
                builder.setMessage("Two Action Buttons Alert Dialog");
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "No is clicked", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Yes is clicked", Toast.LENGTH_LONG).show();
                    }
                });

                builder.show();

                break;

            case R.id.DateBtn:
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.TimeBtn:

                final Calendar c1 = Calendar.getInstance();
                mHour = c1.get(Calendar.HOUR_OF_DAY);
                mMinute = c1.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
                break;

            case R.id.ListBtn:

                builder.setTitle("Make your selection");
                builder.setItems(fruit, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {

                    }
                });
                AlertDialog alert = builder.create();
                alert.show();

                break;

            case R.id.CustomBtn:


                LayoutInflater li = LayoutInflater.from(this);
                View dialogView = li.inflate(R.layout.custom_dialog, null);
                builder.setTitle("Custom Dialog");
                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setView(dialogView);
                final EditText userInput = (EditText) dialogView.findViewById(R.id.et_input);

                builder.setCancelable(false).setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                    }
                                })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                break;
        }
    }


}

