package com.nepalaya.up.exception;

@FunctionalInterface
public interface ExceptionWrapper {
    void handle() throws Exception;
}
