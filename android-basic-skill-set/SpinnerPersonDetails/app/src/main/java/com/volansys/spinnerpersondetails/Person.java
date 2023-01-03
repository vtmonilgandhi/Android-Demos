package com.volansys.spinnerpersondetails;

/**
 * Created by Volansys on 3/1/18.
 */
public class Person {

    public String id;
    public String name;
    public String number;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person(String id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;


    }
}