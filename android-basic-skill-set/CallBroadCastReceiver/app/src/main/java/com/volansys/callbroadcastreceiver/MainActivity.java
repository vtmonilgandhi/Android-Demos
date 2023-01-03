package com.volansys.callbroadcastreceiver;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        PhoneStateListener callStateListener = new PhoneStateListener() {
            public void onCallStateChanged(int state, String incomingNumber) {

                String number = incomingNumber;

                if (state == TelephonyManager.CALL_STATE_RINGING) {
                    Toast.makeText(MainActivity.this, "Phone Is Riging", Toast.LENGTH_LONG).show();

                }

                if (state == TelephonyManager.CALL_STATE_OFFHOOK) {
                    Toast.makeText(MainActivity.this, "Phone is Currently in A call", Toast.LENGTH_LONG).show();
                }


                if (state == TelephonyManager.CALL_STATE_IDLE) {
                    Toast.makeText(MainActivity.this, "phone is neither ringing nor in a call", Toast.LENGTH_LONG).show();
                }
            }
        };
        telephonyManager.listen(callStateListener, PhoneStateListener.LISTEN_CALL_STATE);


    }


}
