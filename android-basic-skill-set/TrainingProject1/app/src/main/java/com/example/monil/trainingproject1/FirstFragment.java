package com.example.monil.trainingproject1;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FirstFragment extends Fragment implements View.OnClickListener {

    Button button;

    public FirstFragment() {

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

        SecondFragment secondFragment = new SecondFragment();
        android.support.v4.app.FragmentManager fm=getFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frag_Container, secondFragment);
        transaction.addToBackStack("1");
        transaction.commit();


    }

}
