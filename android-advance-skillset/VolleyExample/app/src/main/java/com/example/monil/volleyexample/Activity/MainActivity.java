package com.example.monil.volleyexample.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.monil.volleyexample.Model.Person;
import com.example.monil.volleyexample.Adapter.PersonAdapter;
import com.example.monil.volleyexample.R;
import com.example.monil.volleyexample.Utils.AppConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends BaseActivity {


    ArrayList<HashMap<String, String>> contactList;
    ArrayList<Person> personList = new ArrayList<>();
    RequestQueue requestQueue;
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


        contactList = new ArrayList<>();


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, AppConstants.BASE_URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject c = response.getJSONObject(i);
                                Person person = new Person();
                                person.setId(c.getString(AppConstants.KEY_ID));
                                person.setName(c.getString(AppConstants.KEY_NAME_1));
                                person.setMobile(c.getString(AppConstants.KEY_MOBILE));
                                person.setCity(c.getString(AppConstants.KEY_CITY));
                                person.setImage(c.getString(AppConstants.KEY_IMAGE));
                                person.setDate(c.getString(AppConstants.KEY_DATE));
                                person.setCompany(c.getString(AppConstants.KEY_COMPANY));
                                person.setProfessional(c.getString(AppConstants.KEY_PROFFESSIONAL));
                                person.setGender(c.getString(AppConstants.KEY_GENDER_1));
                                personList.add(person);
                            }
                            personAdapter = new PersonAdapter(personList);
                            recyclerView.setAdapter(personAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this, AppConstants.KEY_ERROR, Toast.LENGTH_LONG);
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }


    @Override
    protected void initComponent() {
        recyclerView = (RecyclerView) findViewById(R.id.personLv);

    }

    @Override
    protected void prepareViews() {
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }

    @Override
    protected void setListeners() {

    }
}
