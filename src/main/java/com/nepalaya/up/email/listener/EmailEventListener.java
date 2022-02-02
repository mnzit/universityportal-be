package com.nepalaya.up.email.listener;

import com.nepalaya.up.email.event.EmailEvent;
import com.nepalaya.up.email.service.EmailService;
import com.nepalaya.up.util.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailEventListener {

    private final EmailService emailService;

    public EmailEventListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @Async("emailThreadPool")
    @EventListener
    public void handleContextStart(EmailEvent.EmailWrapper emailWrapper) {
        LogUtil.info("Email event received");
        emailService.send(emailWrapper.getEmailDTO(), emailWrapper.getMailType());
    }
}
