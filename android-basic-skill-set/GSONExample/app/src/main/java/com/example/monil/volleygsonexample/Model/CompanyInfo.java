package com.example.monil.volleygsonexample.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by monil on 25/1/18.
 */

public class CompanyInfo {
    @SerializedName("Department")
    ArrayList<Department> myDepartments;
    ArrayList<Clients> Clients;
    @SerializedName("CEO")
    CEO ceo=new CEO();

    public ArrayList<Department> getMyDepartments() {
        return myDepartments;
    }

    public void setMyDepartments(ArrayList<Department> myDepartments) {
        this.myDepartments = myDepartments;
    }

    public ArrayList<Clients> getClients() {
        return Clients;
    }

    public void setClients(ArrayList<Clients> clients) {
        Clients = clients;
    }

    public CEO getCeo() {
        return ceo;
    }

    public void setCeo(CEO ceo) {
        this.ceo = ceo;
    }
}
