package com.example.monil.analysisexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics firebaseAnalytics;
    String[] foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foods = new String[]{"Apple", "Banana", "Grape", "Mango", "Orange"};

        firebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Food food = new Food();
        food.setId(1);

        food.setName(foods[randomIndex()]);

        Bundle bundle = new Bundle();
        bundle.putInt(FirebaseAnalytics.Param.ITEM_ID, food.getId());
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, food.getName());

        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
        firebaseAnalytics.setAnalyticsCollectionEnabled(true);
        firebaseAnalytics.setMinimumSessionDuration(20000);
        firebaseAnalytics.setSessionTimeoutDuration(500);
        firebaseAnalytics.setUserId(String.valueOf(food.getId()));
        firebaseAnalytics.setUserProperty("Food", food.getName());
    }

    private int randomIndex() {
        int min = 0;
        int max = foods.length - 1;
        Random rand = new Random();
        return min + rand.nextInt((max - min) + 1);
    }
}