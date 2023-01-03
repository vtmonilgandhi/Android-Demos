package com.example.monil.loginmvpdemo.model.response;

/**
 * Response that represents login successful rsult
 * Created by David Bilik[david.bilik@ackee.cz] on {17/12/15}
 **/
public class LoginResponse {
    public static final String TAG = LoginResponse.class.getName();
    int userId;

    public LoginResponse(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }
}
