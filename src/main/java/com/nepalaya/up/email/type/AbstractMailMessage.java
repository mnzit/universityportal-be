package com.nepalaya.up.email.type;

import com.nepalaya.up.email.dto.EmailDTO;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;

public abstract class AbstractMailMessage {

    protected final JavaMailSender emailSender;
    protected final TemplateEngine templateEngine;

    public AbstractMailMessage(JavaMailSender emailSender, TemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    public abstract void send(EmailDTO emailDTO);
}
