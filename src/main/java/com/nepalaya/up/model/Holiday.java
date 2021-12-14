package com.nepalaya.up.model;

import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "HOLIDAYS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Holiday extends BaseEntity<User> {

    @Basic(optional = true)
    @NotBlank
    @Size(min = 2, max = 250)
    @Column(name = "TITLE", nullable = false)
    private String title;

    @Basic(optional = true)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE")
    private Date date;

}