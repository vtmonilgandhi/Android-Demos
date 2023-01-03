package com.example.monil.interfaceexample;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Volansys on 12/2/18.
 */
public class Rectangle extends AppCompatActivity implements Shape {



    @Override
    public String draw() {
        return "Drawing Rectangle";
    }

    @Override
    public double getArea(double width,double height) {
        return height * width;
    }

}