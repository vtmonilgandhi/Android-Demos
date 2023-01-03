package com.volansys.bootbroadcastreceiver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Volansys on 8/1/18.
 */
public class AndroidServiceStartOnBoot extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // here you can add whatever you want this service to do
    }

}