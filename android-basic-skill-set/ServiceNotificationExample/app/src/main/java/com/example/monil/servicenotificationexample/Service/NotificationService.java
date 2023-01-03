package com.example.monil.servicenotificationexample.Service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;

import com.example.monil.servicenotificationexample.Activity.MainActivity;
import com.example.monil.servicenotificationexample.R;
import com.example.monil.servicenotificationexample.Utils.Constants;

/**
 * Created by Volansys on 31/1/18.
 */
public class NotificationService extends Service {

    int NOTIFICATION_ID = 9000;
    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        player = MediaPlayer.create(this,
                Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);
        player.start();
        Notification.Builder builder =
                new Notification.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle(Constants.KEY_TITLE)   //this is the title of notification
                        .setColor(101)
                        .setContentText(Constants.KEY_MESSAGE);   //this is the message showed in notification
        intent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }
}