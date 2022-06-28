package com.nepalaya.up.controller;

import com.nepalaya.up.aop.aspect.Log;
import com.nepalaya.up.aop.aspect.LogExecutionTime;
import com.nepalaya.up.constant.ApiConstant;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.facade.LoginFacade;
import com.nepalaya.up.request.LoginRequest;
import org.springframework.http.HttpStatus;
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

    @Log
    @LogExecutionTime
    @PostMapping(ApiConstant.LOGIN)
    public ResponseEntity<?> authenticateUser(@RequestBody @Valid LoginRequest request) {
        ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.ok();
        Response response = loginFacade.login(request, responseBuilder::headers);
        if(!response.getSuccess()) responseBuilder = ResponseEntity.status(HttpStatus.UNAUTHORIZED);

        return responseBuilder.body(response);
    }
}


