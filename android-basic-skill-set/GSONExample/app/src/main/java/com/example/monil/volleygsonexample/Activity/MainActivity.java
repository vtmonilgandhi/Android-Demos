package com.example.monil.volleygsonexample.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.monil.volleygsonexample.ApiInterface;
import com.example.monil.volleygsonexample.Adapter.InfoAdapter;
import com.example.monil.volleygsonexample.Model.CompanyInfo;
import com.example.monil.volleygsonexample.Model.Department;
import com.example.monil.volleygsonexample.Model.Employees;
import com.example.monil.volleygsonexample.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    ArrayList<Department> departmentArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private InfoAdapter infoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.personLv);
        CompanyDetails();
    }

    public void CompanyDetails()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);

        Call <CompanyInfo> call =api.getMyDepartments();
        call.enqueue(new Callback<CompanyInfo>() {
            @Override
            public void onResponse(Call<CompanyInfo> call, Response<CompanyInfo> response) {
                Log.d(TAG, "onSuccess Server Response " + response.body().getMyDepartments().size() + "");
                ArrayList<Department>departments=response.body().getMyDepartments();
                recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL));
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                infoAdapter=new InfoAdapter(departments);
                recyclerView.setAdapter(infoAdapter);

            }

            @Override
            public void onFailure(Call<CompanyInfo> call, Throwable t) {

            }
        });
    }
}
