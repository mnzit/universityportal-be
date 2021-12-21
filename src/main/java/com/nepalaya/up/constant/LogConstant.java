package com.nepalaya.up.constant;

import org.springframework.http.HttpHeaders;

public interface LogConstant {
    String AUTH_PREFIX_DOESNT_EXIST = "[Authorization Header] doesnt contains prefix '" + SecurityConstant.JWT_PREFIX + "'";
    String AUTH_HEADER_DOESNT_EXIST = "[Authorization Header] with key '" + HttpHeaders.AUTHORIZATION + "'";
    String AUTH_HEADER_INVALID = "[Authorization Header] is invalid";
}
