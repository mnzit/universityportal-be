package com.nepalaya.up.constant;

public interface ApiConstant {

    String PING = "/";
    String LOGIN = "/login";

    // List all the API Paths to bypass Authentication Here
    String[] UNSECURE = new String[]{
            PING,
            LOGIN
    };
}
