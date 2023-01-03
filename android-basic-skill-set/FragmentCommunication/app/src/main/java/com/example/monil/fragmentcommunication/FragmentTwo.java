package com.example.monil.fragmentcommunication;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends Fragment {
    public TextView dataTv;

    public FragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmentView rootView;
        View rootView;
        rootView=  inflater.inflate(R.layout.fragment_fragment_two, container, false);
        FragmentOne fragmentOne =new FragmentOne();

        dataTv=(TextView)rootView.findViewById(R.id.dataTv);
        return rootView;

    }


}
