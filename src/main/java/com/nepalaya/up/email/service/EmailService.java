package com.nepalaya.up.email.service;

import com.nepalaya.up.email.dto.EmailDTO;

public interface EmailService {

    void send(EmailDTO emailDTO);
}
