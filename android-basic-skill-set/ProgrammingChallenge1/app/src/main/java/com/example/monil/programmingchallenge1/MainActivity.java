package com.example.monil.programmingchallenge1;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    EditText editText;
    TextView textView;
    Button button;
    String str;


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
       editText=(EditText)findViewById(R.id.string_edt);
        textView=(TextView)findViewById(R.id.word_tv);
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


        str=editText.getText().toString();
        String[] word=str.split(" ");
        String rts=" ";
        for(int i=0;i<word.length;i++){
            if(word[i].length()>=rts.length()){
                rts=word[i];
            }
        }
        textView.setText(rts);

    }
}
