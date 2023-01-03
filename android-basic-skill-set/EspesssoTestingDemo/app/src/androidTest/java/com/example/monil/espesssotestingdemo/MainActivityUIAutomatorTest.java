package com.example.monil.espesssotestingdemo;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by Volansys on 11/4/18.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityUIAutomatorTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule
            = new ActivityTestRule<MainActivity>(MainActivity.class);

    private UiDevice mDevice;

    @Before
    public void setUp() {
        // Initialize UiDevice instance

        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        // Start from the home screen
        mDevice.pressHome();

        mDevice.wait(Until.hasObject(By.pkg(getLauncherPackageName()).depth(0)), 1000);
    }

    /**
     * @Test public void checkSettings() throws UiObjectNotFoundException {
     * <p>
     * // Simulate a short press on the HOME button.
     * mDevice.pressHome();
     * <p>
     * // We’re now in the home screen. Next, we want to simulate
     * // a user bringing up the All Apps screen.
     * // If you use the uiautomatorviewer tool to capture a snapshot
     * // of the Home screen, notice that the All Apps button’s
     * // content-description property has the value “Apps”. We can
     * // use this property to create a UiSelector to find the button.
     * <p>
     * UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps"));
     * <p>
     * // Simulate a click to bring up the All Apps screen.
     * allAppsButton.click();
     * <p>
     * // In the All Apps screen, the Settings app is located in
     * // the Apps tab. To simulate the user bringing up the Apps tab,
     * // we create a UiSelector to find a tab with the text
     * // label “Apps”.
     * UiObject appsTab = mDevice.findObject(new UiSelector().text("Apps"));
     * <p>
     * // Simulate a click to enter the Apps tab.
     * appsTab.click();
     * <p>
     * // Next, in the apps tabs, we can simulate a user swiping until
     * // they come to the Settings app icon. Since the container view
     * // is scrollable, we can use a UiScrollable object.
     * UiScrollable appViews = new UiScrollable(
     * new UiSelector().scrollable(true));
     * <p>
     * // Set the swiping mode to horizontal (the default is vertical)
     * appViews.setAsHorizontalList();
     * <p>
     * // create a UiSelector to find the Settings app and simulate
     * // a user click to launch the app.
     * UiObject settingsApp = appViews
     * .getChildByText(new UiSelector()
     * .className(android.widget.TextView.class.getName()),
     * "Settings");
     * settingsApp.clickAndWaitForNewWindow();
     * <p>
     * // Validate that the package name is the expected one
     * UiObject settingsValidation = new UiObject(
     * new UiSelector()
     * .packageName("com.android.settings"));
     * assertThat(settingsValidation.exists(), equalTo(true));
     * }
     **/

    @Test
    public void openRapidIoT() throws UiObjectNotFoundException {
        mDevice.pressHome();
        mDevice.swipe(200, 500, 200, 100, 10);
        UiObject rapidIoTApp = mDevice.findObject(new UiSelector().text("Modular Gateway Mgr"));
        rapidIoTApp.click();
        mDevice.findObject(new UiSelector().text("Next")).clickAndWaitForNewWindow();
        mDevice.findObject(new UiSelector().text("Submit")).click();
    }

    @Test
    public void openSettings() throws UiObjectNotFoundException {
        mDevice.pressHome();
        mDevice.swipe(200, 500, 200, 100, 10);
        UiObject rapidIoTApp = mDevice.findObject(new UiSelector().text("Settings"));
        rapidIoTApp.clickAndWaitForNewWindow();
        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
        appViews.setAsVerticalList();
        UiObject systemInfo =
                appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),
                        "System");
        systemInfo.clickAndWaitForNewWindow();
    }

    private String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        // Use PackageManager to get the launcher package name
        PackageManager pm = InstrumentationRegistry.getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }
}
