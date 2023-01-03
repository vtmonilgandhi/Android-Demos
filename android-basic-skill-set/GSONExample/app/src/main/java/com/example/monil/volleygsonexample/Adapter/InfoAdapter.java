package com.example.monil.volleygsonexample.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.monil.volleygsonexample.Model.Department;
import com.example.monil.volleygsonexample.R;

import java.util.ArrayList;

/**
 * Created by monil on 24/1/18.
 */

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder> {

    ArrayList<Department> Department;

    public InfoAdapter(ArrayList<Department> Department) {
        this.Department = Department;
    }

    @Override
    public InfoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(InfoAdapter.ViewHolder holder, int position) {
        com.example.monil.volleygsonexample.Model.Department department = Department.get(position);
        holder.id.setText(department.getId());
        holder.name.setText(department.getName());
        holder.hod_name.setText(department.getHod_name());
        holder.image.setText(department.getImage());
        //  holder.isSaturdayoff.setText(department.getSaturdayoff());

    }

    @Override
    public int getItemCount() {
        return Department.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView id, name, hod_name,image;
        ListView employeeLv;

        public ViewHolder(View view) {
            super(view);
            id = (TextView) view.findViewById(R.id.idTv);
             name = (TextView) view.findViewById(R.id.nameTv);
             hod_name = (TextView) view.findViewById(R.id.hodTv);
             image = (TextView) view.findViewById(R.id.imageTv);


        }
    }

}
