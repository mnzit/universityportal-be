package com.nepalaya.up.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "COURSES")
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
    private String duration;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<CourseSubject> subjects;

}