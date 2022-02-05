package com.nepalaya.up.controller;

import com.nepalaya.up.constant.ApiConstant;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.request.ResetPasswordRequest;
import com.nepalaya.up.service.ForgotPasswordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ForgotPasswordController {
    private final ForgotPasswordService forgotPasswordService;

    public ForgotPasswordController(ForgotPasswordService forgotPasswordService) {
        this.forgotPasswordService = forgotPasswordService;
    }

    @PostMapping(ApiConstant.RESET_LINK)
    public Response forgotPassword(@Valid @RequestParam(name = "email") String email) {
        return forgotPasswordService.forgotPassword(email);
    }

    @PostMapping(ApiConstant.RESET_PASSWORD)
    public Response resetPassword(@RequestBody @Valid ResetPasswordRequest request) {
        return forgotPasswordService.resetPassword(request);
    }
}
