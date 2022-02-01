package com.nepalaya.up.controller;

import com.nepalaya.up.constant.ApiConstant;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.email.dto.EmailDto;
import com.nepalaya.up.email.service.EmailService;
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
    private final EmailService emailService;

    public AuthController(LoginFacade loginFacade, EmailService emailService) {
        this.loginFacade = loginFacade;
        this.emailService = emailService;
    }

    @PostMapping(ApiConstant.LOGIN)
    public ResponseEntity<?> authenticateUser(@RequestBody @Valid LoginRequest request) {

        ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.ok();
        Response response = loginFacade.login(request, responseBuilder::headers);
        new Thread(() -> emailService.send(new EmailDto("universityportal123@gmail.com", "mnzitshakya@gmail.com", "Test", "Testing message"))).start();
        return responseBuilder.body(response);
    }
}


