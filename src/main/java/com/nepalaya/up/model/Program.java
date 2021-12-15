package com.nepalaya.up.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Timer;

@Entity
@Table(name = "PROGRAMS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Program extends BaseEntity<User> {

    @Basic(optional = true)
    @NotBlank
    @Size(min = 2, max = 150)
    @Column(name = "YEAR", nullable = false)
    private String year;

    @Basic(optional = true)
    @NotBlank
    @Size(min = 2, max = 150)
    @Column(name = "MONTH", nullable = false)
    private String month;

    @JsonBackReference
    @NotBlank
    @Size(min = 2, max = 150)
    @ManyToOne
    @Basic(optional = false)
    @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID")
    private Course course;

}