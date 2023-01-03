package com.example.monil.retrofitexample.Activity;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.monil.retrofitexample.Adapter.PersonAdapter;
import com.example.monil.retrofitexample.Api;
import com.example.monil.retrofitexample.Model.Person;
import com.example.monil.retrofitexample.R;
import com.example.monil.retrofitexample.Utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseActivity {


    ArrayList<Person> personList = new ArrayList<>();
    private String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        prepareViews();
        setListeners();


        getDetails();
    }

    private void getDetails() {


        Api api = Api.retrofit.create(Api.class);

        Call<List<Person>> call = api.personDetails();
        call.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {

                ArrayList<Person> personList1 = (ArrayList<Person>) response.body();
                for (int i = 0; i < personList1.size(); i++) {
                    Person person = new Person();
                    String Name = personList1.get(i).getName();
                    person.setName(Name);
                    personList.add(person);
                }

                recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL));

                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                personAdapter = new PersonAdapter(personList);
                recyclerView.setAdapter(personAdapter);
            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                Toast.makeText(MainActivity.this, AppConstants.KEY_ERROR, Toast.LENGTH_LONG);
            }
        });


    }

    @Override
    protected void initComponent() {
        recyclerView = (RecyclerView) findViewById(R.id.personLv);
    }

    @Override
    protected void prepareViews() {

    }

    @Override
    protected void setListeners() {

    }
}