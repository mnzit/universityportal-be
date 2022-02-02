package com.nepalaya.up.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "email_configs")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailConfig extends BaseEntity<User> {

    @Column(length = 150, name = "TYPE", nullable = false)
    private String type;

    @Column(length = 150, name = "TEMPLATE")
    private String template;
}
