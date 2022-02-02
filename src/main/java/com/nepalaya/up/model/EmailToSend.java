package com.nepalaya.up.model;

import com.nepalaya.up.model.enums.EmailState;
import lombok.*;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

@Entity
@Table(name = "emails_to_send")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailToSend extends BaseEntity<User> {

    @Column(length = 150, name = "BODY")
    private String body;

    @Column(length = 150, name = "RECEIVER", nullable = false)
    private String receiver;

    @Column(length = 150, name = "CC")
    private String cc;

    @Column(length = 150, name = "BCC")
    private String bcc;

    @Column(length = 150, name = "SUBJECT")
    private String subject;

    @ManyToOne
    @JoinColumn(name = "EMAIL_CONFIG_ID", referencedColumnName = "ID")
    private EmailConfig emailConfig;

    @Column(name = "STATE", columnDefinition = "VARCHAR(100) DEFAULT 'PENDING'")
    @Enumerated(EnumType.STRING)
    @org.hibernate.annotations.Generated(GenerationTime.INSERT)
    private EmailState state;

}
