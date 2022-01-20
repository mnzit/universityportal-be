package com.nepalaya.up.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHORITIES")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authority extends BaseEntity<User> {

    @Column(length = 50, name = "NAME", nullable = false)
    private String name;
}
