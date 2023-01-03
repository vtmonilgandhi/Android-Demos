package com.example.monil.databindingexample;

/**
 * Created by Volansys on 9/2/18.
 */
import java.util.ArrayList;
import java.util.List;

public class Data {

    static public List<MyModel> list;

    static {
        list = new ArrayList<>();
        list.add(new MyModel("Monil"));
        list.add(new MyModel("Jay"));
        list.add(new MyModel("Raj"));
        list.add(new MyModel("Ronak"));
        list.add(new MyModel("Purvesh"));
        list.add(new MyModel("Bhavik"));
    }

}