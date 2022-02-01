package com.nepalaya.up.model;

import com.nepalaya.up.model.enums.DurationType;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COURSES")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@org.hibernate.annotations.Cache(region = "courses", usage = CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
public class Course extends BaseEntity<User> {

    @Column(length = 200, name = "TITLE", nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(length = 2, name = "DURATION", nullable = false)
    private Double duration;

    @Column(name = "DURATION_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private DurationType durationType = DurationType.YEAR;

    @Column(name="CREDIT_HR_PER_SEMESTER")
    private Long creditHrPerSemester;

    @Column(name="SEMESTER")
    private Long semester;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<CourseSubject> subjects;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Program> programs;

}