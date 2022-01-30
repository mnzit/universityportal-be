package com.nepalaya.up.facade;

import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.callback.AuthCallback;
import com.nepalaya.up.constant.ResponseMsgConstant;
import com.nepalaya.up.constant.SecurityConstant;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.request.LoginRequest;
import com.nepalaya.up.util.JwtUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LoginFacade {

    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;


    public LoginFacade(UserDetailsService userDetailsService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public Response login(LoginRequest request, AuthCallback authCallback) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmailAddress());

        String requestPassword = request.getPassword();
        String savedPassword = userDetails.getPassword();

        if (passwordEncoder.matches(requestPassword,savedPassword)) {
            // Generating token
            String token = jwtUtil.generateToken(userDetails);
            // Setting token in header
            HttpHeaders responseHeaders = new HttpHeaders();

            responseHeaders.set(
                    HttpHeaders.AUTHORIZATION, new StringBuilder()
                    .append(SecurityConstant.JWT_PREFIX)
                    .append(token)
                    .toString()
            );

            authCallback.patch(responseHeaders);
            // Return response
            return ResponseBuilder.success(ResponseMsgConstant.LOGIN_SUCCESSFUL);
        } else {
            return ResponseBuilder.failure(ResponseMsgConstant.LOGIN_FAILED);
        }
    }
}
