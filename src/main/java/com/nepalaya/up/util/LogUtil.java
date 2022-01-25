package com.nepalaya.up.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogUtil {

    public static void exception(Exception ex) {
        log.error("[Exception]: " + ex.getMessage());
    }

    public static void exception(String message) {
        log.error("[Exception]: " + message);
    }


    public static void info(String message) {
        log.info("[Info]: " + message);
    }

}
