package com.volansys.spinnerpersondetails;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Volansys on 3/1/18.
 */
public class PersonAdapter extends BaseAdapter {

    Activity activity;
    ArrayList<Person> personArrayList;
    public int chooseSpinner;



    public PersonAdapter(Activity activity, int chooseSpinner, ArrayList<Person> personArrayList) {
        this.activity = activity;
        this.chooseSpinner = chooseSpinner;
        this.personArrayList = personArrayList;

    }


    @Override
    public int getCount() {
        return personArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return personArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return personArrayList.indexOf(getItem(i));
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.person_list, viewGroup, false);
        TextView id = (TextView) view.findViewById(R.id.idTv);
        TextView name = (TextView) view.findViewById(R.id.nameTv);
        TextView number = (TextView) view.findViewById(R.id.numberTv);

        if (chooseSpinner == 0)
            id.setText(personArrayList.get(i).getId());
        if (chooseSpinner == 1)
            name.setText(personArrayList.get(i).getName());
        if (chooseSpinner == 2)
            number.setText(personArrayList.get(i).getNumber());
        return view;
    }


}
