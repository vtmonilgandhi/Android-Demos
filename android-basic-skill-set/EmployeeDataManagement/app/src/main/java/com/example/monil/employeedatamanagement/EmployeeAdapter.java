package com.example.monil.employeedatamanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Volansys on 28/12/17.
 */
public class EmployeeAdapter extends ArrayAdapter<EmployeeHelper> {
    public EmployeeAdapter(Context context, ArrayList<EmployeeHelper> employeeHelpers) {
        super(context,0,employeeHelpers);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        EmployeeHelper employeeHelper = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.employee_list, parent, false);
        }

        TextView tvId = (TextView) convertView.findViewById(R.id.tvId);
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvDesignation = (TextView) convertView.findViewById(R.id.tvDesignation);
        TextView tvSalary = (TextView) convertView.findViewById(R.id.tvSalary);

        tvId.setText(employeeHelper.id);
        tvName.setText(employeeHelper.Name);
        tvDesignation.setText(employeeHelper.Designation);
        tvSalary.setText(employeeHelper.Salary);


        return convertView;
    }
}