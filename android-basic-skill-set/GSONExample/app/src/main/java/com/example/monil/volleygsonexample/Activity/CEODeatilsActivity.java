package com.example.monil.volleygsonexample.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.monil.volleygsonexample.ApiInterface;
import com.example.monil.volleygsonexample.Model.CEO;
import com.example.monil.volleygsonexample.Model.CompanyInfo;
import com.example.monil.volleygsonexample.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CEODeatilsActivity extends AppCompatActivity {
    private static final String TAG = CEODeatilsActivity.class.getSimpleName();

    public TextView name, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceodeatils);
        name = (TextView) findViewById(R.id.nameTv);
        address = (TextView) findViewById(R.id.addressTv);


        CompanyDetails();
    }

    public void CompanyDetails()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);

        Call<CompanyInfo> call =api.getCeo();
        call.enqueue(new Callback<CompanyInfo>() {
            @Override
            public void onResponse(Call<CompanyInfo> call, Response<CompanyInfo> response) {
                 Log.d(TAG, "onSuccess Server Response " + response.body().getCeo() + "");
                CEO ceo=response.body().getCeo();
                name.setText(ceo.getName().toString());
                address.setText(ceo.getAddress().toString());

            }

            @Override
            public void onFailure(Call<CompanyInfo> call, Throwable t) {

            }
        });
    }
}
