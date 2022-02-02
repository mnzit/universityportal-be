package com.nepalaya.up.email.producer;

import com.nepalaya.up.email.dto.EmailDTO;
import com.nepalaya.up.email.event.EmailEvent;
import com.nepalaya.up.email.factory.MailType;
import com.nepalaya.up.util.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailEventProducer {

    private final ApplicationEventPublisher applicationEventPublisher;

    public EmailEventProducer(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void sendEmail(EmailDTO emailDTO, MailType mailType){
        LogUtil.info("Email event produced");
        applicationEventPublisher.publishEvent(new EmailEvent.EmailWrapper(emailDTO, mailType));
    }
}
