package com.nepalaya.up.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SystemException extends RuntimeException{

    public SystemException(String message) {
        super(message);
    }

    public SystemException(Throwable cause) {
        super("System Error!", cause);
        log.debug("Exception: "+ cause.getMessage());
    }

    public SystemException() {
        super("System Error!");
    }
}
