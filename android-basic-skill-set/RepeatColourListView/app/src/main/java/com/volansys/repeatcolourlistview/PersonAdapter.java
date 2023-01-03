package com.volansys.repeatcolourlistview;

import android.graphics.Color;
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

        if (position % 3 == 0) {
            holder.itemView.setBackgroundColor(Color.parseColor("Red"));
        } else if (position % 3 == 1) {
            holder.itemView.setBackgroundColor(Color.parseColor("Green"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("Blue"));
        }
        Person person = personArrayList.get(position);

        holder.genre.setText(person.getName());

    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView genre;

        public ViewHolder(View view) {
            super(view);

            genre = (TextView) view.findViewById(R.id.nameTv);

        }
    }
}

