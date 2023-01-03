package com.volansys.checkboxlistview;

/**
 * Created by Volansys on 3/1/18.
 */
public class Person {

    private boolean isSelected;
    public String name;


    public Person(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

}