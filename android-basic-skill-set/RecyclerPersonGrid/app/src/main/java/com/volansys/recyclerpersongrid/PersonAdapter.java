package com.volansys.recyclerpersongrid;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person = personArrayList.get(position);
        holder.title.setText(person.getId());
        holder.genre.setText(person.getName());
        holder.year.setText(person.getNumber());
    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.idTv);
            genre = (TextView) view.findViewById(R.id.nameTv);
            year = (TextView) view.findViewById(R.id.numberTv);
        }
    }
}

