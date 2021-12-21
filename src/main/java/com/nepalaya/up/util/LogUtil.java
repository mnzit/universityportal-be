package com.nepalaya.up.util;

public class LogUtil {

    public static void exception(Exception ex) {
        System.out.println("[Exception]: " + ex.getMessage());
    }

    public static void exception(String message) {
        System.out.println("[Exception]: " + message);
    }

}
