package com.example.monil.eventbusexample;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Volansys on 10/4/18.
 */
public class GlobalBus {

    private static EventBus eventBus;

    public static EventBus getBus() {
        if (eventBus == null)
            eventBus = EventBus.getDefault();
        return eventBus;
    }
}
