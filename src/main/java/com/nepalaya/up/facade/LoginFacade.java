package com.nepalaya.up.facade;

import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.callback.AuthCallback;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.request.LoginRequest;
import com.nepalaya.up.util.JwtUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class LoginFacade {

    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    public LoginFacade(UserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    public Response login(LoginRequest request, AuthCallback authCallback) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmailAddress());
        String requestPassword = request.getPassword();
        String savedPassword = userDetails.getPassword();
        if (requestPassword.equals(savedPassword)) {
            // Generating token
            String token = jwtUtil.generateToken(userDetails);
            // Setting token in header
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set(HttpHeaders.AUTHORIZATION, token);
            authCallback.patch(responseHeaders);
            // Return response
            return ResponseBuilder.success("Login Successful");
        } else {
            return ResponseBuilder.failure("Email/Password is incorrect");
        }
    }
}
