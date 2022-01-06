package com.nepalaya.up.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_PROGRAMS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Program extends BaseEntity<User> {

    @Column(length = 10, name = "YEAR", nullable = false)
    private Long year;

    @Column(length  = 2, name = "MONTH", nullable = false)
    private Long month;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID")
    private Course course;

}