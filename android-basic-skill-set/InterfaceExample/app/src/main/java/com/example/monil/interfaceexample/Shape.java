package com.example.monil.interfaceexample;

/**
 * Created by Volansys on 12/2/18.
 */

/**
 * It is not necessery to overrider all methods of interface
 */
public interface Shape {


    //implicitly public, static and final
    public String msg = "The Area of Rectangle :" ;

    //interface methods are implicitly abstract and public
    String draw();

    double getArea(double width,double height);
}