package com.example.ganalysisexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleScreenTrackingAnalytics();
    }

    public void showMessage(View view) {
        handleEventTrackingAnalytics("Button Click", "Show Message");
        Toast toast = Toast.makeText(getApplicationContext(), "Button is clicked.", Toast.LENGTH_SHORT);
        toast.show();
    }
    private void handleScreenTrackingAnalytics() {
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        Tracker mTracker = application.getDefaultTracker();
        mTracker.setScreenName("MainActivity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }
    private void handleEventTrackingAnalytics(final String category, final String action) {
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        Tracker mTracker = application.getDefaultTracker();
        mTracker.setScreenName("MainActivity");
        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory(category)
                .setAction(action)
                .build());
    }
}