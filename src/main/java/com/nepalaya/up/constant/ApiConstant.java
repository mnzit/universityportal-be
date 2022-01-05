package com.nepalaya.up.constant;

public interface ApiConstant {

    String PING = "/";
    String LOGIN = "/login";
    String PROFILE = "/profile";
    String USERS = "/users";
    String USER = "/user";
    String USER_EMAIL = "userEmail";
    String USER_BY_EMAIL = "/" + "{" + USER_EMAIL + "}";

    String BOOK = "/book";
    String ALL = "/all";
    String COPY = "/copy";

    // List all the API Paths to bypass Authentication Here
    String[] UNSECURE = new String[]{
            PING,
            LOGIN
    };
}
