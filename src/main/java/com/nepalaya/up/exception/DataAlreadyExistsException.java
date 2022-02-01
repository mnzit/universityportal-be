package com.nepalaya.up.exception;

public class DataAlreadyExistsException extends RuntimeException{

    public DataAlreadyExistsException(String message) {
        super(message);
    }

    public DataAlreadyExistsException() {
        super("Title already exists!!");
    }

}
