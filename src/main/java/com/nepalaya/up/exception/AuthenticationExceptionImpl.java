package com.nepalaya.up.exception;

import org.springframework.security.core.AuthenticationException;

public class AuthenticationExceptionImpl extends AuthenticationException {
    public AuthenticationExceptionImpl() {
        super("Unauthorized!");
    }
}
