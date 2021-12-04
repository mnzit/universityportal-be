package com.nepalaya.up.exception;

import com.nepalaya.up.dto.Response;

@FunctionalInterface
public interface ExceptionDataWrapper {
    Response handle() throws Exception;
}
