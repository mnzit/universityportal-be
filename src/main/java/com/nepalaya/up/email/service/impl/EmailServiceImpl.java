package com.nepalaya.up.email.service.impl;

import com.nepalaya.up.email.dto.EmailDto;
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
    public void send(EmailDto emailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailDto.getFrom());
        message.setTo(emailDto.getTo());
        message.setSubject(emailDto.getSubject());
        message.setText((String) emailDto.getData());
        emailSender.send(message);
    }
}
