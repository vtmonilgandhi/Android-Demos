package com.volansys.personhttpget.Activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.volansys.personhttpget.Adapter.PersonAdapter;
import com.volansys.personhttpget.Model.HttpHandler;
import com.volansys.personhttpget.Model.Person;
import com.volansys.personhttpget.R;
import com.volansys.personhttpget.Utils.AppConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends BaseActivity {

    // URL to get contacts JSON
    ArrayList<HashMap<String, String>> contactList;
    ArrayList<Person> personList = new ArrayList<>();
    private String TAG = MainActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private ListView lv;
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


        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        new GetContacts().execute();
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


    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {

            HttpHandler sh = new HttpHandler();

            String jsonStr = sh.makeServiceCall(AppConstants.URL_JSONDATA);

            if (jsonStr != null) {
                try {


                    JSONArray contacts = new JSONArray(jsonStr);

                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);
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
                } catch (final JSONException e) {

                }
            }
            return null;
        }


        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (pDialog.isShowing()) {
                pDialog.dismiss();


                personAdapter = new PersonAdapter(personList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(personAdapter);


            }
        }

    }
}
