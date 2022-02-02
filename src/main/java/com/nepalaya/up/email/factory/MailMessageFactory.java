package com.nepalaya.up.email.factory;

import com.nepalaya.up.email.type.AbstractMailMessage;
import org.springframework.stereotype.Component;

@Component
public class MailMessageFactory {

    private final AbstractMailMessage simpleMail;
    private final AbstractMailMessage mimeMail;

    public MailMessageFactory(@MailTypeSelector(MailType.SIMPLE) AbstractMailMessage simpleMail,
                              @MailTypeSelector(MailType.MIME_THYMELEAF) AbstractMailMessage mimeMail) {
        this.simpleMail = simpleMail;
        this.mimeMail = mimeMail;
    }

    public AbstractMailMessage get(MailType mailType){
        switch (mailType){
            case MIME_THYMELEAF:
                return simpleMail;
            case SIMPLE:
                return mimeMail;
            default:
                throw new RuntimeException("Mail type missing");
        }
    }
}
