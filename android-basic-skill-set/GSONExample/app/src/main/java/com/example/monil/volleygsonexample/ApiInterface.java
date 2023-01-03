package com.example.monil.volleygsonexample;

import com.example.monil.volleygsonexample.Model.CompanyInfo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by monil on 24/1/18.
 */

public interface ApiInterface {

    public String BASE_URL = "https://demo7041036.mockable.io/";
    @GET("getCompanyInformation")
    Call<CompanyInfo> getMyDepartments();
    @GET("getCompanyInformation")
    Call<CompanyInfo> getClients();
    @GET("getCompanyInformation")
    Call<CompanyInfo> getCeo();

}
