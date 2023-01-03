package com.example.monil.tempraturebindingexample;

/**
 * Created by Volansys on 11/4/18.
 */
public interface MainActivityContract {
     interface Presenter {
        void onShowData(TemperatureData temperatureData);
    }

     interface View {
        void showData(TemperatureData temperatureData);
    }

}