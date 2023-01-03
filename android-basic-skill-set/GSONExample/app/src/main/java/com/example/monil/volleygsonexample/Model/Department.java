package com.example.monil.volleygsonexample.Model;

import java.util.ArrayList;

/**
 * Created by monil on 24/1/18.
 */

public class Department  {
    String id;
    String name;
    String hod_name;
    String image;
    Boolean isSaturdayoff;
    ArrayList<Employees> employees;

    public ArrayList<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employees> employees) {
        this.employees = employees;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHod_name() {
        return hod_name;
    }

    public void setHod_name(String hod_name) {
        this.hod_name = hod_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getSaturdayoff() {
        return isSaturdayoff;
    }

    public void setSaturdayoff(Boolean saturdayoff) {
        isSaturdayoff = saturdayoff;
    }


}
