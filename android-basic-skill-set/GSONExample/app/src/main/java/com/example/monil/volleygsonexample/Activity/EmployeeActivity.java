package com.example.monil.volleygsonexample.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.monil.volleygsonexample.Adapter.EmployeeAdapter;
import com.example.monil.volleygsonexample.ApiInterface;
import com.example.monil.volleygsonexample.Model.CompanyInfo;
import com.example.monil.volleygsonexample.Model.Department;
import com.example.monil.volleygsonexample.Model.Employees;
import com.example.monil.volleygsonexample.R;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmployeeActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    ArrayList<Employees> employeesArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private EmployeeAdapter employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        recyclerView = (RecyclerView) findViewById(R.id.personLv);
        CompanyDetails();
    }

    public void CompanyDetails() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);

        Call<CompanyInfo> call = api.getMyDepartments();
        call.enqueue(new Callback<CompanyInfo>() {
            @Override
            public void onResponse(Call<CompanyInfo> call, Response<CompanyInfo> response) {
                Log.d(TAG, "onSuccess Server Response " + response.body().getMyDepartments().size() + "");
                ArrayList<Department> departments = response.body().getMyDepartments();

                for (int i = 0; i < departments.size(); i++) {
                    ArrayList<Employees> employees = new ArrayList<>();
                    employees = departments.get(i).getEmployees();
                    for (int j = 0; j < employees.size(); j++) {
                        Employees employees1 = new Employees();
                        String id = employees.get(j).getId();
                        String name = employees.get(j).getName();
                        String exp = employees.get(j).getExperience();
                        String hobbies[] = employees.get(j).getHobbies();
                        employees1.setId(id);
                        employees1.setName(name);
                        employees1.setExperience(exp);
                        employees1.setHobbies(hobbies);
                        employeesArrayList.add(employees1);
                    }
                }
                recyclerView.addItemDecoration(new DividerItemDecoration(EmployeeActivity.this, LinearLayoutManager.VERTICAL));
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                employeeAdapter = new EmployeeAdapter(employeesArrayList);
                recyclerView.setAdapter(employeeAdapter);
            }

            @Override
            public void onFailure(Call<CompanyInfo> call, Throwable t) {

            }
        });
    }
}
