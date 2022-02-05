package com.nepalaya.up.service;

import com.nepalaya.up.dto.Response;
import com.nepalaya.up.request.ResetPasswordRequest;


public interface ForgotPasswordService {
    Response forgotPassword(String email);

    Response resetPassword(ResetPasswordRequest request);
}
