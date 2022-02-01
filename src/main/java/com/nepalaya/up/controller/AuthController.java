package com.nepalaya.up.controller;

import com.nepalaya.up.constant.ApiConstant;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.email.dto.EmailDTO;
import com.nepalaya.up.email.producer.EmailEventProducer;
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
    private final EmailEventProducer emailEventProducer;

    public AuthController(LoginFacade loginFacade, EmailEventProducer emailEventProducer) {
        this.loginFacade = loginFacade;
        this.emailEventProducer = emailEventProducer;
    }

    @PostMapping(ApiConstant.LOGIN)
    public ResponseEntity<?> authenticateUser(@RequestBody @Valid LoginRequest request) {
        ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.ok();
        Response response = loginFacade.login(request, responseBuilder::headers);
        emailEventProducer.sendEmail(new EmailDTO("universityportal123@gmail.com", "mnzitshakya@gmail.com", "Test", "Testing message"));
        return responseBuilder.body(response);
    }
}


