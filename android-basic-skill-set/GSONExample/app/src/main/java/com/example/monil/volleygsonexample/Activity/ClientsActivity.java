package com.example.monil.volleygsonexample.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.monil.volleygsonexample.Adapter.ClientsAdapter;
import com.example.monil.volleygsonexample.ApiInterface;
import com.example.monil.volleygsonexample.Model.Clients;
import com.example.monil.volleygsonexample.Model.CompanyInfo;
import com.example.monil.volleygsonexample.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientsActivity extends AppCompatActivity {
    ArrayList<Clients> clientsArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ClientsAdapter clientsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients);
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

        Call<CompanyInfo> call =api.getClients();
        call.enqueue(new Callback<CompanyInfo>() {
            @Override
            public void onResponse(Call<CompanyInfo> call, Response<CompanyInfo> response) {
              //  Log.d(TAG, "onSuccess Server Response " + response.body().getDepartment().size() + "");
                ArrayList<Clients>clients=response.body().getClients();
                recyclerView.addItemDecoration(new DividerItemDecoration(ClientsActivity.this, LinearLayoutManager.VERTICAL));

                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                clientsAdapter=new ClientsAdapter(clients);
                recyclerView.setAdapter(clientsAdapter);

            }

            @Override
            public void onFailure(Call<CompanyInfo> call, Throwable t) {

            }
        });
    }
}
