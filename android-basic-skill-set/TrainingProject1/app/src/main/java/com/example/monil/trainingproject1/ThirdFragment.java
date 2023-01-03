package com.example.monil.trainingproject1;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment implements View.OnClickListener{

Button button;
    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        button = (Button) view.findViewById(R.id.btn3);
        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        FirstFragment firstFragment=new FirstFragment();
        android.support.v4.app.FragmentManager fm=getFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frag_Container, firstFragment);
        fm.popBackStack("1", FragmentManager.POP_BACK_STACK_INCLUSIVE);
        transaction.commit();


    }

}
