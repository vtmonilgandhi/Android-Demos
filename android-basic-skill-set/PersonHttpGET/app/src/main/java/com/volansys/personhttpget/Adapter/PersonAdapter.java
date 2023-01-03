package com.volansys.personhttpget.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.volansys.personhttpget.Model.Person;
import com.volansys.personhttpget.R;

import java.util.ArrayList;

/**
 * Created by Volansys on 3/1/18.
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private ArrayList<Person> personArrayList = new ArrayList<>();


    public PersonAdapter(ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;

    }

    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person = personArrayList.get(position);
        holder.id.setText(person.getId());
        holder.name.setText(person.getName());
        holder.mobile.setText(person.getMobile());
        holder.city.setText(person.getCity());
        holder.img.setText(person.getImage());
        holder.date.setText(person.getDate());
        holder.company.setText(person.getCompany());
        holder.profile.setText(person.getProfessional());
        holder.gender.setText(person.getGender());
    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView id, name, mobile,city,img,date,company,profile,gender;

        public ViewHolder(View view) {
            super(view);
            id = (TextView) view.findViewById(R.id.idTv);
            name = (TextView) view.findViewById(R.id.name);
            mobile = (TextView) view.findViewById(R.id.mobile);
            city = (TextView) view.findViewById(R.id.city);
            img = (TextView) view.findViewById(R.id.img);
            date = (TextView) view.findViewById(R.id.date);
            company = (TextView) view.findViewById(R.id.company);
            profile = (TextView) view.findViewById(R.id.profile);
            gender = (TextView) view.findViewById(R.id.gender);
        }
    }
}

