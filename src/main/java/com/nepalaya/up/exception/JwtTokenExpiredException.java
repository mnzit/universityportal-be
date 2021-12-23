package com.nepalaya.up.exception;

import com.nepalaya.up.constant.ResponseMsgConstant;
import org.springframework.security.core.AuthenticationException;

public class JwtTokenExpiredException extends AuthenticationException {
    public JwtTokenExpiredException() {
        super(ResponseMsgConstant.AUTHENTICATION_TOKEN_EXPIRED);
    }
}
