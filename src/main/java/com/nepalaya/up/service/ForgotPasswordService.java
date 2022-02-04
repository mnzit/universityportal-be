package com.nepalaya.up.service;

import com.nepalaya.up.dto.Response;
import com.nepalaya.up.request.ForgetPasswordRequest;

public interface ForgotPasswordService {
    Response forgotPassword(ForgetPasswordRequest request);

}
