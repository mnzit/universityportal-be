package com.nepalaya.up.email.type;

import com.nepalaya.up.email.dto.EmailDTO;
import com.nepalaya.up.email.factory.MailType;
import com.nepalaya.up.email.factory.MailTypeSelector;
import com.nepalaya.up.util.LogUtil;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Objects;

@Component
@MailTypeSelector(MailType.MIME_THYMELEAF)
public class MimeMail extends AbstractMailMessage {

    public MimeMail(JavaMailSender emailSender, TemplateEngine templateEngine) {
        super(emailSender, templateEngine);
    }

    @Override
    public void send(EmailDTO emailDTO) {
        try {
            Map<String, Object> map = (Map<String, Object>) emailDTO.getData();
            Context context = new Context();

            map.forEach(context::setVariable);

            String process = templateEngine.process((String) "emails/" + map.get("template"), context);
            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setSubject(emailDTO.getSubject());
            helper.setText(process, true);
            helper.setTo(emailDTO.getTo());
            helper.setFrom(Objects.requireNonNull(((JavaMailSenderImpl) emailSender).getUsername()));
            emailSender.send(mimeMessage);
        }catch (Exception exception){
            LogUtil.exception(exception);
        }
    }
}
