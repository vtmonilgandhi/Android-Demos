package com.volansys.httpgetwithjasonexample.Activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.volansys.httpgetwithjasonexample.HttpHandler;
import com.volansys.httpgetwithjasonexample.R;
import com.volansys.httpgetwithjasonexample.Utils.AppConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    private String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;

    // URL to get contacts JSON
   // private static String url = ;

    private EditText latEdt,longEdt;
    private TextView addTv;
    private Button addBtn;
    String addre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.enableDefaults();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initComponent();
        prepareViews();
        setListeners();



    }

    @Override
    protected void initComponent() {
        latEdt=(EditText)findViewById(R.id.latEdt);
        longEdt=(EditText)findViewById(R.id.longEdt);
        addTv=(TextView)findViewById(R.id.addTv);
        addBtn=(Button)findViewById(R.id.addBtn);


    }

    @Override
    protected void prepareViews() {

    }

    @Override
    protected void setListeners() {
        addBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String lat=latEdt.getText().toString();
        String longe=longEdt.getText().toString();
        new AsynckMkeCall(lat,longe).execute();
    }


    public void GetAddress(String lat,String longe)
    {

            HttpHandler sh = new HttpHandler();


            String jsonStr = sh.makeServiceCall(AppConstants.JSON_URL+lat+","+longe+"&sensor=true");

            Log.e(TAG, "Response from url: " + jsonStr);

            JSONObject jsonObject;


            try {
                jsonObject = new JSONObject(jsonStr);


                addre = ((JSONArray)jsonObject.get(AppConstants.KEY_RESULT)).getJSONObject(0).getString(AppConstants.KEY_ADDRESS);


            } catch (JSONException e) {

                Toast.makeText(getApplicationContext(),
                        e.toString(),Toast.LENGTH_LONG).show();
                e.printStackTrace();

            }

        }

        private class AsynckMkeCall extends  AsyncTask<Void,Void,Void>{
            String lat,longe;

            public AsynckMkeCall(String lat, String longe) {
                this.lat = lat;
                this.longe = longe;
            }

            @Override
            protected Void doInBackground(Void... voids) {
                GetAddress(lat,longe);
                return null;

            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                addTv.setText(addre);
            }
        }


    }


