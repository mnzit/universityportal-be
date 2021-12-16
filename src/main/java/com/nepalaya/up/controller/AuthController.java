package com.nepalaya.up.controller;

import com.nepalaya.up.dto.Response;
import com.nepalaya.up.manager.LoginManager;
import com.nepalaya.up.request.LoginRequest;
import com.nepalaya.up.response.LoginResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

    private final LoginManager loginManager;

    public AuthController(LoginManager loginManager) {
        this.loginManager = loginManager;
    }

    @PostMapping("login")
    public ResponseEntity<?> authenticateUser(@RequestBody @Valid LoginRequest request) {
        Response response = loginManager.login(request);
        LoginResponse data = (LoginResponse) response.getData();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization", data.getToken());
        return ResponseEntity
                .ok()
                .headers(responseHeaders)
                .body(response);
    }
}
