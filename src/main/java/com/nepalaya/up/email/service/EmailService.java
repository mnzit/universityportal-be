package com.nepalaya.up.email.service;

import com.nepalaya.up.email.dto.EmailDto;

public interface EmailService {

    void send(EmailDto emailDto);
}
