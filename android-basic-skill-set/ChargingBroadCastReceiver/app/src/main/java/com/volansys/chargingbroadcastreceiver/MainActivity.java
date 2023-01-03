package com.volansys.chargingbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private PlugInConnector plugInConnector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plugInConnector=new PlugInConnector();
    }
    public class PlugInConnector extends BroadcastReceiver
    {

        @Override
        public void onReceive(Context context, Intent intent) {

            String action = intent.getAction();

            if(action.equals(Intent.ACTION_POWER_CONNECTED))
            {
                // Do something when power connected
                Toast.makeText(context, "connected", Toast.LENGTH_LONG).show();
            }
            else if(action.equals(Intent.ACTION_POWER_DISCONNECTED))
            {
                // Do something when power disconnected
                Toast.makeText(context, "Disconnected", Toast.LENGTH_LONG).show();
            }
        }
    }
}
