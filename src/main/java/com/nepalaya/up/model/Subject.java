package com.nepalaya.up.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SUBJECTS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subject extends BaseEntity<User> {

    @Column(length = 150, name = "TITLE", nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(length = 3, name = "CREDIT_HOURS", nullable = false)
    private Long creditHour;
}