package com.nepalaya.up.model;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HOLIDAYS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@org.hibernate.annotations.Cache(region = "holidays", usage = CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
public class Holiday extends BaseEntity<User> {

    @Column(length = 150, name = "TITLE", nullable = false)
    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE", nullable = false)
    private Date date;

}