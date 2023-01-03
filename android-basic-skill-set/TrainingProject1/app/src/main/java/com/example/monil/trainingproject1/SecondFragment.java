package com.example.monil.trainingproject1;

import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class SecondFragment extends Fragment implements View.OnClickListener{

    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        button = (Button) view.findViewById(R.id.btn2);
        button.setOnClickListener(this);

        return view;
       }

    @Override
    public void onClick(View view) {


        ThirdFragment thirdFragment=new ThirdFragment();
        android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frag_Container, thirdFragment);
        transaction.addToBackStack("1");
        transaction.commit();


    }
}
