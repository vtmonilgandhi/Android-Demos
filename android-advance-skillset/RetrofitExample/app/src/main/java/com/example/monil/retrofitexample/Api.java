package com.example.monil.retrofitexample;

import com.example.monil.retrofitexample.Model.Person;
import com.example.monil.retrofitexample.Utils.AppConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by monil on 23/1/18.
 */

public interface Api {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
            .build();

    @GET("getData")
    Call<List<Person>> personDetails();
}