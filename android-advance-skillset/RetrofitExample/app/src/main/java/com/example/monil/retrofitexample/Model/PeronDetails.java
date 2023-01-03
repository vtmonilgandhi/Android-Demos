package com.example.monil.retrofitexample.Model;

import com.example.monil.retrofitexample.Model.Person;

import java.util.ArrayList;

/**
 * Created by monil on 23/1/18.
 */

public class PeronDetails {

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    private ArrayList<Person> personList;


}
