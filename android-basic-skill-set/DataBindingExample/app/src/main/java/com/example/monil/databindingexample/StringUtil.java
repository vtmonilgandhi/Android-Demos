package com.example.monil.databindingexample;

import java.text.DateFormat;

/**
 * Created by Volansys on 9/2/18.
 */
public class StringUtil {

    public static String format(long millis) {
        return DateFormat.getTimeInstance().format(millis);
    }

}