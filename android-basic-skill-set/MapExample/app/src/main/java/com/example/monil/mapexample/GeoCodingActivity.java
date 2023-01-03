package com.example.monil.mapexample;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

public class GeoCodingActivity extends AppCompatActivity {

    private static final String[] INITIAL_PERMS = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };
    private static final int INITIAL_REQUEST = 13;
    Button btnGPSShowLocation;
    Button btnShowAddress;
    TextView tvAddress;
    EditText latEdt, longEdt, addressEdit;
    private MyLocation myLocation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_coding);
        tvAddress = (TextView) findViewById(R.id.tvAddress);
        myLocation = new MyLocation();
        latEdt = (EditText) findViewById(R.id.latitudeEdit);
        longEdt = (EditText) findViewById(R.id.longitudeEdit);
        addressEdit = (EditText) findViewById(R.id.addressEdit);
        btnGPSShowLocation = (Button) findViewById(R.id.btnGPSShowLocation);
        btnGPSShowLocation.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View arg0) {

                String address = addressEdit.getText().toString();
                getLocationFromAddress(address);
            }
        });

        btnShowAddress = (Button) findViewById(R.id.btnShowAddress);
        btnShowAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                double latitude = Double.parseDouble(latEdt.getText().toString());
                double longitude = Double.parseDouble(longEdt.getText().toString());
                LocationAddress locationAddress = new LocationAddress();
                locationAddress.getAddressFromLocation(latitude, longitude,
                        getApplicationContext(), new GeocoderHandler());

            }
        });

    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioAddress:
                if (checked) {
                    longEdt.setEnabled(false);
                    latEdt.setEnabled(false);
                    addressEdit.setEnabled(true);
                    addressEdit.requestFocus();
                    btnShowAddress.setVisibility(View.INVISIBLE);
                    btnGPSShowLocation.setVisibility(View.VISIBLE);

                }
                break;
            case R.id.radioLocation:
                if (checked) {
                    latEdt.setEnabled(true);
                    latEdt.requestFocus();
                    longEdt.setEnabled(true);
                    addressEdit.setEnabled(false);
                    btnGPSShowLocation.setVisibility(View.INVISIBLE);
                    btnShowAddress.setVisibility(View.VISIBLE);

                }
                break;
        }
    }


    private boolean canAccessLocation() {
        return (hasPermission(Manifest.permission.ACCESS_FINE_LOCATION));
    }

    private boolean canAccessCoreLocation() {
        return (hasPermission(Manifest.permission.ACCESS_COARSE_LOCATION));
    }

    private boolean hasPermission(String perm) {

        return (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(GeoCodingActivity.this, perm));
    }


    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                GeoCodingActivity.this);
        alertDialog.setTitle("SETTINGS");
        alertDialog.setMessage("Enable Location Provider! Go to settings menu?");
        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        GeoCodingActivity.this.startActivity(intent);
                    }
                });
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }


    public LatLng getLocationFromAddress(String strAddress) {

        Geocoder coder = new Geocoder(this);
        List<Address> address;
        LatLng p1 = null;

        try {
            // May throw an IOException
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();

            p1 = new LatLng(location.getLatitude(), location.getLongitude());
            tvAddress.setText("Latitude: " + location.getLatitude() + "\n" +
                    "Longitude: " + location.getLongitude() + "\n" +
                    "Address: " + address.get(0));


        } catch (IOException ex) {

            ex.printStackTrace();
        }

        return p1;
    }

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
            tvAddress.setText(locationAddress);
        }
    }
}
