package com.example.monil.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Volansys on 13/4/18.
 */
public class MyService extends Service {
    private IBinder mBinder = new MyBinder();
    public MyService() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.w("onCreate", "Service is created");
    }

    public int onStartCommand(Intent intent, int id, int startID) {
        Log.w("onCreate", "onStartCommand is called");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w("onCreate", "Service is Destroyed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.w("onCreate", "Service is bind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.w("onCreate", "Service is unbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.w("onCreate", "Service is rebind");
        super.onRebind(intent);
    }

    public class MyBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }
}
