package com.nepalaya.up.email.event;

import com.nepalaya.up.email.dto.EmailDTO;
import com.nepalaya.up.email.factory.MailType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

public class EmailEvent extends ApplicationEvent {

    public EmailEvent(EmailWrapper emailWrapper) {
        super(emailWrapper);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class EmailWrapper {
        private EmailDTO emailDTO;
        private MailType mailType;
    }
}
