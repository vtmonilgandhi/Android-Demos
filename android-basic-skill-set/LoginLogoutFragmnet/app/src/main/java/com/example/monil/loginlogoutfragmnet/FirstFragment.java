package com.example.monil.loginlogoutfragmnet;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FirstFragment extends Fragment implements View.OnClickListener{

    Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        button = (Button) view.findViewById(R.id.btn1);
        button.setOnClickListener(this);

        return view;

    }


    @Override
    public void onClick(View view) {

        SecondFragment secondFragment=new SecondFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frag_Container, secondFragment);
        transaction.addToBackStack(null);
        transaction.commit();


    }
}