package com.nepalaya.up.model;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
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
@org.hibernate.annotations.Cache(region = "authorities", usage = CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
public class Authority extends BaseEntity<User> {

    @Column(length = 50, name = "NAME", nullable = false)
    private String name;
}
