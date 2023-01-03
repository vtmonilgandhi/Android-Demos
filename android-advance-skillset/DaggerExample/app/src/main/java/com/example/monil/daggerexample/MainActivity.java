package com.example.monil.daggerexample;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Inject
    SharedPreferences sharedPreferences;
    private EditText mUsernameEditText, mNumberEditText;
    private Button mSaveButton, mGetButton;
    private MyComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        mComponent = DaggerMyComponent.builder().sharedPrefModule(new SharedPrefModule(this)).build();
        mComponent.inject(this);
    }

    private void initViews() {
        mGetButton = findViewById(R.id.btnGet);
        mSaveButton = findViewById(R.id.btnSave);
        mUsernameEditText = findViewById(R.id.inUsername);
        mNumberEditText = findViewById(R.id.inNumber);
        mSaveButton.setOnClickListener(this);
        mGetButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnGet:
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Saved Info")
                        .setMessage("Name : " + sharedPreferences.getString("username", "-/-") + "\n" +
                                "Number : " + sharedPreferences.getString("number", "-/-"))
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .create().show();
                break;
            case R.id.btnSave:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", mUsernameEditText.getText().toString().trim());
                editor.putString("number", mNumberEditText.getText().toString().trim());
                editor.apply();
                break;

        }
    }
}
