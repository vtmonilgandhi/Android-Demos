package com.example.monil.trainingproject1;

<<<<<<< HEAD
=======
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
>>>>>>> 306da3b378576ca2dec29e87f3df9b850a2286d1
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
=======
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
>>>>>>> 306da3b378576ca2dec29e87f3df9b850a2286d1

public class Tab2Fragment extends Fragment {


<<<<<<< HEAD
=======

>>>>>>> 306da3b378576ca2dec29e87f3df9b850a2286d1
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tab2, container, false);

<<<<<<< HEAD
        FourthFragment fourthFragment = new FourthFragment();
        android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frag_Container2, fourthFragment);
        transaction.commit();

=======
        Button lgbtn=(Button)rootView.findViewById(R.id.regBtn);
        final CheckBox checkBox=(CheckBox)rootView.findViewById(R.id.checkbox_star);
        final EditText passwdtv=(EditText) rootView.findViewById(R.id.edt_passwd);
        final EditText cpasswdtv=(EditText) rootView.findViewById(R.id.edt_cpasswd);
        final EditText nametv=(EditText) rootView.findViewById(R.id.edt_name);
        final EditText unametv=(EditText) rootView.findViewById(R.id.edt_uname);
        final EditText emailtv=(EditText) rootView.findViewById(R.id.edt_email);


        lgbtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                String passwd=passwdtv.getText().toString();
                String cpasswd=cpasswdtv.getText().toString();

                String email=emailtv.getText().toString();

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


                if( nametv.getText().toString().length() == 0 ) {
                    nametv.requestFocus();
                    nametv.setError("First name is required!");
                }

                else if( unametv.getText().toString().length() == 0 ) {
                    unametv.requestFocus();
                    unametv.setError("User name is required!");
                }
                else if(passwdtv.getText().toString().length() == 0) {
                    passwdtv.requestFocus();
                    passwdtv.setError("Enter password");
                }
               else if (!cpasswd.equals(passwd)) {
                    cpasswdtv.requestFocus();
                    cpasswdtv.setError("Enter correct password");
                }

                else if  (!email.matches(emailPattern))
                {
                    emailtv.requestFocus();
                    emailtv.setError( "Enter correct email" );
                }

                else if (!checkBox.isChecked())
                {
                    checkBox.setError( "Please are condition" );
                }
                else {
                    Intent i = new Intent(getActivity(), WelcomeActivity.class);
                    getActivity().startActivity(i);
                }

            }
        });
>>>>>>> 306da3b378576ca2dec29e87f3df9b850a2286d1
        return rootView;


    }

}
