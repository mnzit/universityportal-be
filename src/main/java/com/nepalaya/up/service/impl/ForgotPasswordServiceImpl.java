package com.nepalaya.up.service.impl;

import com.nepalaya.up.dto.Response;
import com.nepalaya.up.repository.UserRepository;
import com.nepalaya.up.request.ForgetPasswordRequest;
import com.nepalaya.up.service.ForgotPasswordService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ForgotPasswordServiceImpl implements ForgotPasswordService {

    private final UserRepository userRepository;


    public ForgotPasswordServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Response forgotPassword(ForgetPasswordRequest request) {
        return null;
    }
}
