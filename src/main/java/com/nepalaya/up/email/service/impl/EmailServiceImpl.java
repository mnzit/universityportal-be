package com.nepalaya.up.email.service.impl;

import com.nepalaya.up.email.dto.EmailDTO;
import com.nepalaya.up.email.service.EmailService;
import com.nepalaya.up.util.JacksonUtil;
import com.nepalaya.up.util.LogUtil;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;

    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void send(EmailDTO emailDTO) {
        LogUtil.info("Email : {}", JacksonUtil.toJson(emailDTO));
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(Objects.requireNonNull(((JavaMailSenderImpl) emailSender).getUsername()));
        message.setTo(emailDTO.getTo());
        message.setSubject(emailDTO.getSubject());
        message.setText((String) emailDTO.getData());
        emailSender.send(message);
    }
}
