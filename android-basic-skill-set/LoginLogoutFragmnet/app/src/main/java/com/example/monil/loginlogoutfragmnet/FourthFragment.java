package com.example.monil.loginlogoutfragmnet;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FourthFragment extends Fragment implements View.OnClickListener {

    Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fourth, container, false);
        button = (Button) view.findViewById(R.id.btn4);
        button.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {
        FirstFragment firstFragment=new FirstFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        FragmentManager fm=getFragmentManager();
        transaction.replace(R.id.frag_Container, firstFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);


    }
}
