package com.example.monil.tempraturebindingexample;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Volansys on 11/4/18.
 */
public class TemperatureData extends BaseObservable {
    private String location;
    private String celsius;

    public TemperatureData(String location, String celsius) {
        this.location = location;
        this.celsius = celsius;
    }

    @Bindable
    public String getCelsius() {
        return celsius;
    }

    @Bindable
    public String getLocation() {
        return location;
    }

    public  void setLocation(String location){
        this.location = location;
        notifyPropertyChanged(com.example.monil.tempraturebindingexample.BR.location);
    }

    public void setCelsius(String celsius) {
        this.celsius = celsius;
        notifyPropertyChanged(com.example.monil.tempraturebindingexample.BR.celsius);
    }

}