package com.nepalaya.up.email.service.impl;

import com.nepalaya.up.email.dto.EmailDTO;
import com.nepalaya.up.email.service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;

    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void send(EmailDTO emailDTO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailDTO.getFrom());
        message.setTo(emailDTO.getTo());
        message.setSubject(emailDTO.getSubject());
        message.setText((String) emailDTO.getData());
        emailSender.send(message);
    }
}
