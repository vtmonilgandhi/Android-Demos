package com.example.monil.personinfobook;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @BindView(R.id.input_name)
    EditText inputName;
    @BindView(R.id.input_email)
    EditText inputEmail;
    @BindView(R.id.input_phone)
    EditText inputPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_enter)
    public void onButtonClick(View view) {
        pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        editor = pref.edit();
        editor.putString("inputName", inputName.getText().toString());
        editor.putString("inputEmail", inputEmail.getText().toString());
        editor.putString("inputPhone", inputPhone.getText().toString());
        editor.apply();
        Toast.makeText(getApplicationContext(), "Save", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_get)
    public void onButtonClickGet(View view) {
        Toast.makeText(this, pref.getString("inputName", null) + "\n" +
                pref.getString("inputEmail", null) + "\n" +
                pref.getString("inputPhone", null), Toast.LENGTH_LONG).show();
    }
}