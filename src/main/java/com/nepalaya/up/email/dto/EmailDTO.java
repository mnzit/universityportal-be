package com.nepalaya.up.email.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmailDTO {

    private String from;
    private String to;
    private List<String> cc;
    private List<String> bcc;
    private String subject;
    private Object data;

    public EmailDTO(String from, String to, String subject, Object data) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.data = data;
    }
}
