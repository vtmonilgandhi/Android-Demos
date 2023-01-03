package com.example.android.testing.uiautomator.BasicSample;

/**
 * Created by hardik on 21/2/18.
 */


import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ClearNotificationTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule
            = new ActivityTestRule<MainActivity>(MainActivity.class);

    private UiDevice mDevice;

    @Before
    public void setUp() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    /**
     * Below test case is use to clear notification from notification panel.
     * @throws UiObjectNotFoundException
     */
    @Test
    public void clearNotification() throws UiObjectNotFoundException {

        mDevice.swipe(0,0,200,200,2);

        UiObject2 payButton = mDevice.findObject (By.text("CLEAR ALL"));
        if (payButton.getText().equalsIgnoreCase("CLEAR ALL")) {
            payButton.click();
        }

    }
}
