package com.nepalaya.up.config;

import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.constant.ResponseMsgConstant;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.util.JacksonUtil;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationEntryPointImpl {

    public static void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException authException) throws IOException {
        res.setContentType(MediaType.APPLICATION_JSON_VALUE);
        res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        if(authException instanceof UsernameNotFoundException){
            Response response = ResponseBuilder.failure(authException.getMessage());
            JacksonUtil.objectMapper.writeValue(res.getOutputStream(), response);
        }else{
            Response response = ResponseBuilder.failure(ResponseMsgConstant.UNAUTHORIZED);
            JacksonUtil.objectMapper.writeValue(res.getOutputStream(), response);
        }
    }

    public static void accessDenied(HttpServletRequest req, HttpServletResponse res, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        res.setContentType(MediaType.APPLICATION_JSON_VALUE);
        res.setStatus(HttpServletResponse.SC_FORBIDDEN);
        Response response = ResponseBuilder.failure(ResponseMsgConstant.ACCESS_DENIED);
        JacksonUtil.objectMapper.writeValue(res.getOutputStream(), response);
    }

}
