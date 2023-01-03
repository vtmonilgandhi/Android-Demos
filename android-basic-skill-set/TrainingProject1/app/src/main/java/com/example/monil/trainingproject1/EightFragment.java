package com.example.monil.trainingproject1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class EightFragment extends Fragment implements View.OnClickListener{


    Button button;

    public EightFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eight, container, false);
        button = (Button) view.findViewById(R.id.btn8);
        button.setOnClickListener(this);

        return view;

    }


    @Override
    public void onClick(View view) {

        NineFragment nineFragment = new NineFragment();
        android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frag_Container3, nineFragment);
        transaction.addToBackStack("3");
        transaction.commit();


    }

}
