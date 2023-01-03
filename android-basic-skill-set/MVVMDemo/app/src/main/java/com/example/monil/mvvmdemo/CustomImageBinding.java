package com.example.monil.mvvmdemo;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Volansys on 13/4/18.
 */
public class CustomImageBinding {
    @BindingAdapter({"android:textSize"})
    public static void setTextSize(TextView textView,float size) {
        textView.setTextSize(50);
    }
}