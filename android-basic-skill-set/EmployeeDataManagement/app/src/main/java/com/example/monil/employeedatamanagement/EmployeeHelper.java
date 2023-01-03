package com.example.monil.employeedatamanagement;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Volansys on 28/12/17.
 */
public class EmployeeHelper implements Parcelable {

    public static final Creator<EmployeeHelper> CREATOR = new Creator<EmployeeHelper>() {
        @Override
        public EmployeeHelper createFromParcel(Parcel in) {
            return new EmployeeHelper(in);
        }

        @Override
        public EmployeeHelper[] newArray(int size) {
            return new EmployeeHelper[size];
        }
    };
    public String id;
    public String Name;
    public String Designation;
    public String Salary;

    public EmployeeHelper(String id, String name, String designation, String salary) {
        this.id = id;
        Name = name;
        Designation = designation;
        Salary = salary;
    }

    protected EmployeeHelper(Parcel in) {
        id = in.readString();
        Name = in.readString();
        Designation = in.readString();
        Salary = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(Name);
        parcel.writeString(Designation);
        parcel.writeString(Salary);
    }
}

