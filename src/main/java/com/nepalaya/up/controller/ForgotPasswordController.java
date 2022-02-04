package com.nepalaya.up.controller;

import com.nepalaya.up.constant.ApiConstant;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.request.ForgetPasswordRequest;
import com.nepalaya.up.service.ForgotPasswordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ForgotPasswordController {

    private final ForgotPasswordService forgotPasswordService;

    public ForgotPasswordController(ForgotPasswordService forgotPasswordService) {
        this.forgotPasswordService = forgotPasswordService;
    }

    @PostMapping(ApiConstant.FORGOT_PASSWORD)
    public Response forgotPassword(@RequestBody @Valid ForgetPasswordRequest request) {
        return forgotPasswordService.forgotPassword(request);
    }
}
