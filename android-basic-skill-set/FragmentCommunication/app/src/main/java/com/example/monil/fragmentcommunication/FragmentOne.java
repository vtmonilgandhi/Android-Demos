package com.example.monil.fragmentcommunication;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment implements View.OnClickListener {
    private EditText dataEdt;
    private Button sendBtn;
    public buttonPress press;

    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView;
        rootView= inflater.inflate(R.layout.fragment_fragment_one, container, false);
        dataEdt=(EditText)rootView.findViewById(R.id.dataEdt);
        sendBtn=(Button)rootView.findViewById(R.id.sendBtn);
        sendBtn.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {

        press.getTextData(dataEdt.getText().toString());
    }

    public interface buttonPress {
        void getTextData(String inputText);
    }

    public void setPress(buttonPress press) {
        this.press = press;
    }
}

