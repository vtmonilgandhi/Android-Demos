package com.example.monil.daggerexample;

import android.app.Activity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Volansys on 9/4/18.
 */
@Singleton
@Component(modules = {SharedPrefModule.class})
public interface MyComponent {
    void inject(MainActivity activity);
}