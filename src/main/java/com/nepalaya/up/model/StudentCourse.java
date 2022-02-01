package com.nepalaya.up.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT_COURSES")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@org.hibernate.annotations.Cache(region = "student_courses", usage = CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
public class StudentCourse extends BaseEntity<User> {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    @Column(name = "SEMESTER")
    private Long semester;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID")
    private Course course;

}