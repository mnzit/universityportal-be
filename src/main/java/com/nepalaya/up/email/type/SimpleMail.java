package com.nepalaya.up.email.type;

import com.nepalaya.up.email.dto.EmailDTO;
import com.nepalaya.up.email.factory.MailType;
import com.nepalaya.up.email.factory.MailTypeSelector;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;

import java.util.Objects;

@Component
@MailTypeSelector(MailType.SIMPLE)
public class SimpleMail extends AbstractMailMessage {

    public SimpleMail(JavaMailSender emailSender, TemplateEngine templateEngine) {
        super(emailSender, templateEngine);
    }

    @Override
    public void send(EmailDTO emailDTO) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(Objects.requireNonNull(((JavaMailSenderImpl) emailSender).getUsername()));
        mailMessage.setTo(emailDTO.getTo());
        mailMessage.setSubject(emailDTO.getSubject());
        mailMessage.setText((String) emailDTO.getData());
        emailSender.send(mailMessage);
    }
}
