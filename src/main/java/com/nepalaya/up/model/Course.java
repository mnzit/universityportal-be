package com.nepalaya.up.model;

import lombok.*;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "COURSE")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course extends BaseEntity<User> {

    @Basic(optional = true)
    @NotBlank
    @Size(min = 2, max = 150)
    @Column(name = "TITLE", nullable = false)
    private String title;

    @Basic(optional = true)
    @NotBlank
    @Size(min = 2, max = 1000)
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Basic(optional = true)
    @NotBlank
    @Size(min = 2, max = 150)
    @Column(name = "DURATION", nullable = false)
    private Date duration;



}