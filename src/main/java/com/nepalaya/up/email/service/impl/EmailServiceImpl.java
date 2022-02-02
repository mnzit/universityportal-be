package com.nepalaya.up.email.service.impl;

import com.nepalaya.up.email.dto.EmailDTO;
import com.nepalaya.up.email.factory.MailMessageFactory;
import com.nepalaya.up.email.factory.MailType;
import com.nepalaya.up.email.service.EmailService;
import com.nepalaya.up.util.JacksonUtil;
import com.nepalaya.up.util.LogUtil;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final MailMessageFactory mailMessageFactory;

    public EmailServiceImpl(MailMessageFactory mailMessageFactory) {
        this.mailMessageFactory = mailMessageFactory;
    }

    @Override
    public void send(EmailDTO emailDTO, MailType mailType) {
        LogUtil.info("Email : {}", JacksonUtil.toJson(emailDTO));
        try {
             mailMessageFactory
                     .get(mailType)
                     .send(emailDTO);

        } catch (Exception ex) {
            LogUtil.exception(ex);
        }
    }
}
