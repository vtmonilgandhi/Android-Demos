package com.example.monil.trainingproject2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MessageFragment extends Fragment implements View.OnClickListener {

    public buttonPress press;
    private Button button;

    public MessageFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        button = (Button) view.findViewById(R.id.btn);
        button.setOnClickListener(this);

        return view;

    }


    @Override
    public void onClick(View view) {

        press.getTextData("Received from fragmnet");
    }

    public interface buttonPress {
        void getTextData(String inputText);
    }

    public void setPress(buttonPress press) {
        this.press = press;
    }
}