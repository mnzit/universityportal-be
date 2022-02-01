package com.nepalaya.up.email.event;

import com.nepalaya.up.email.dto.EmailDTO;
import org.springframework.context.ApplicationEvent;

public class EmailEvent extends ApplicationEvent {

    public EmailEvent(EmailDTO emailDTO) {
        super(emailDTO);
    }
}
