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
public class SevenFragment extends Fragment implements View.OnClickListener {


    Button button;

    public SevenFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_seven, container, false);
        button = (Button) view.findViewById(R.id.btn7);
        button.setOnClickListener(this);

        return view;

    }


    @Override
    public void onClick(View view) {

        EightFragment eightFragment = new EightFragment();
        android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frag_Container3, eightFragment);
        transaction.addToBackStack("3");
        transaction.commit();


    }

}
