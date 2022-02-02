package com.nepalaya.up.email.service;

import com.nepalaya.up.email.dto.EmailDTO;
import com.nepalaya.up.email.factory.MailType;

public interface EmailService {

    void send(EmailDTO emailDTO, MailType mailType);
}
