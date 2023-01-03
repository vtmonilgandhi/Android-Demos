package com.example.monil.trainingproject1;

import android.app.Activity;
<<<<<<< HEAD
import android.app.FragmentManager;
=======
>>>>>>> 306da3b378576ca2dec29e87f3df9b850a2286d1
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
<<<<<<< HEAD
import android.support.v4.app.FragmentTransaction;
=======
>>>>>>> 306da3b378576ca2dec29e87f3df9b850a2286d1
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Tab1Fragment extends Fragment {


<<<<<<< HEAD
=======

>>>>>>> 306da3b378576ca2dec29e87f3df9b850a2286d1
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tab1, container, false);
<<<<<<< HEAD
        FirstFragment firstFragment=new FirstFragment();
        android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frag_Container,firstFragment );
        transaction.commit();
        return rootView;


    }

=======
        Button lgbtn=(Button)rootView.findViewById(R.id.lgBtn);
        final EditText unametv=(EditText) rootView.findViewById(R.id.edt_lname);
        final EditText passwdtv=(EditText) rootView.findViewById(R.id.edt_lpasswd);

        lgbtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                 String name=unametv.getText().toString();
                 String passwd=passwdtv.getText().toString();

                if (name.equals("monil") && passwd.equals("monil")) {

                    Intent i = new Intent(getActivity(), WelcomeActivity.class);
                    getActivity().startActivity(i);
                }

            }
        });
        return rootView;



    }
>>>>>>> 306da3b378576ca2dec29e87f3df9b850a2286d1


}
