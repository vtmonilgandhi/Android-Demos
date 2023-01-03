package com.volansys.checkboxlistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Volansys on 3/1/18.
 */
public class PersonAdapter extends BaseAdapter {

    Activity activity;
    ArrayList<Person> personArrayList;
    boolean[] checkBoxState;


    public PersonAdapter(Activity activity, ArrayList<Person> personArrayList) {
        this.activity = activity;
        this.personArrayList = personArrayList;
        checkBoxState = new boolean[personArrayList.size()];
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.item_list, viewGroup, false);

        TextView name = (TextView) view.findViewById(R.id.nameTv);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.check);
        if (view == null) {

            view.setTag(checkBox);
        } else {
            name.setText(personArrayList.get(i).getName());
            checkBox.setChecked(checkBoxState[i]);
            checkBox.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    if (((CheckBox) v).isChecked())
                        checkBoxState[i] = true;
                    else
                        checkBoxState[i] = false;
                }
            });
        }
        return view;
    }


}
