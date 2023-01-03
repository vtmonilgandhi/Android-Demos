package com.example.ganalysisexample;

import android.app.Application;
import com.google.android.gms.analytics.GoogleAnalytics;

/**
 * Created by Volansys on 16/4/18.
 */
public class AnalyticsApplication extends Application {
    private Tracker tracker;
    synchronized public Tracker getDefaultTracker() {
        if (tracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            tracker = analytics.newTracker(R.xml.analytics);
        }
        return tracker;
    }
}
