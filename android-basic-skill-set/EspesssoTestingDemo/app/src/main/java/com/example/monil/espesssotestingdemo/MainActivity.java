package com.example.monil.espesssotestingdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button changeTextBtn,switchActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.inputField);
        changeTextBtn=findViewById(R.id.changeText);
        switchActivityBtn=findViewById(R.id.switchActivity);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.changeText:
                editText.setText("Lalala");
                break;
            case R.id.switchActivity:
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("input", editText.getText().toString());
                startActivity(intent);
                break;

            case R.id.check:
                if((editText.getText().toString()).equals("done"))
                {
                    changeTextBtn.setVisibility(View.VISIBLE);
                    switchActivityBtn.setVisibility(View.VISIBLE);
                    editText.setText("");
                }
        }
    }
}
