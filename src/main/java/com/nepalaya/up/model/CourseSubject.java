package com.nepalaya.up.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "COURSE_SUBJECTS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@org.hibernate.annotations.Cache(region = "course_subjects", usage = CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
public class CourseSubject extends BaseEntity<User> {

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "SUBJECT_ID", referencedColumnName = "ID")
    private Subject subject;
}
