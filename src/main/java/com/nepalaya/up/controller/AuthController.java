package com.nepalaya.up.controller;

import com.nepalaya.up.dto.Response;
import com.nepalaya.up.facade.LoginFacade;
import com.nepalaya.up.request.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class AuthController {

    private final LoginFacade loginFacade;

    public AuthController(LoginFacade loginFacade) {
        this.loginFacade = loginFacade;
    }

    @PostMapping("login")
    public ResponseEntity<?> authenticateUser(@RequestBody @Valid LoginRequest request) {
        ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.ok();
        Response response = loginFacade.login(request, responseBuilder::headers);
        return responseBuilder.body(response);
    }
}


