package com.example.monil.contentproviderexample.Utils;

import android.net.Uri;

/**
 * Created by Volansys on 30/1/18.
 */
public class AppConstants {

    public static final String PROVIDER_NAME = "com.example.monil.contentproviderexample.Provider.StudentsProvider";
    public static final String GET_DATA_URL = "content://" + PROVIDER_NAME + "/students";
    public static final Uri CONTENT_URI = Uri.parse(GET_DATA_URL);
    public static final String _ID = "_id";
    public static final String NAME = "name";
    public static final String GRADE = "grade";
    public static final int STUDENTS = 1;
    public static final int STUDENT_ID = 2;
    public static final String ERROR ="Failed to add a record into ";
}
