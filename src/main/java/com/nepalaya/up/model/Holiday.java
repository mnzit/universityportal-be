package com.nepalaya.up.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HOLIDAYS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Holiday extends BaseEntity<User> {

    @Column(length = 150, name = "TITLE", nullable = false)
    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE", nullable = false)
    private Date date;

}