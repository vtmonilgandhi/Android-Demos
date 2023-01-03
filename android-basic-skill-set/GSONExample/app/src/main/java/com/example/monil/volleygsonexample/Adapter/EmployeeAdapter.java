package com.example.monil.volleygsonexample.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.monil.volleygsonexample.Model.Employees;
import com.example.monil.volleygsonexample.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by monil on 25/1/18.
 */

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {

    ArrayList<Employees> employees;

    public EmployeeAdapter(ArrayList<Employees> employees) {
        this.employees = employees;
    }

    @Override
    public EmployeeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(EmployeeAdapter.ViewHolder holder, int position) {
        Employees employee = employees.get(position);
        holder.id.setText(employee.getId());
        holder.name.setText(employee.getName());
        holder.experience.setText(employee.getExperience());
        String hobbies=Arrays.toString(employee.getHobbies());
        holder.hobbies.setText(hobbies);

    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView id, name, experience,hobbies;
        ListView employeeLv;

        public ViewHolder(View view) {
            super(view);
            id = (TextView) view.findViewById(R.id.idTv);
            name = (TextView) view.findViewById(R.id.nameTv);
            experience = (TextView) view.findViewById(R.id.experienceTv);
            hobbies = (TextView) view.findViewById(R.id.hobbiesTv);


        }
    }
}

