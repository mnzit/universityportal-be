package com.nepalaya.up.email.service.impl;

import com.nepalaya.up.email.dto.EmailDTO;
import com.nepalaya.up.email.service.EmailService;
import com.nepalaya.up.util.JacksonUtil;
import com.nepalaya.up.util.LogUtil;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Objects;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;
    private final TemplateEngine templateEngine;

    public EmailServiceImpl(JavaMailSender emailSender, TemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public void send(EmailDTO emailDTO) {
        LogUtil.info("Email : {}", JacksonUtil.toJson(emailDTO));
        try {
            if (emailDTO.getIsMime()) {
                Map<String, Object> map = (Map<String, Object>) emailDTO.getData();
                Context context = new Context();

                map.forEach((k, v) -> {
                    context.setVariable(k, v);
                });

                String process = templateEngine.process((String) "emails/" + map.get("template"), context);
                MimeMessage mimeMessage = emailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
                helper.setSubject(emailDTO.getSubject());
                helper.setText(process, true);
                helper.setTo(emailDTO.getTo());
                helper.setFrom(Objects.requireNonNull(((JavaMailSenderImpl) emailSender).getUsername()));
                emailSender.send(mimeMessage);
            } else {
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setFrom(Objects.requireNonNull(((JavaMailSenderImpl) emailSender).getUsername()));
                mailMessage.setTo(emailDTO.getTo());
                mailMessage.setSubject(emailDTO.getSubject());
                mailMessage.setText((String) emailDTO.getData());
                emailSender.send(mailMessage);
            }

        } catch (Exception ex) {
            LogUtil.exception(ex);
        }
    }
}
