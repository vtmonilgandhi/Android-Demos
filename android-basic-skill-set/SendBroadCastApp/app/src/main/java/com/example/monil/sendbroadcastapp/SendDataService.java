package com.example.monil.sendbroadcastapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class SendDataService extends Service {
    public SendDataService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        sendMessage();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void sendMessage() {
        Intent intent = new Intent("send");
        intent.putExtra("current speed", "102.4");
        intent.putExtra("latitude", "12.2342342");
        intent.putExtra("longitude", "12.21124");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

    }
}
