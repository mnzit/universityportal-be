package com.nepalaya.up.model;

import com.nepalaya.up.model.enums.DurationType;
import lombok.*;
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
public class Course extends BaseEntity<User> {

    @Column(length = 200, name = "TITLE", nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(length = 2, name = "DURATION", nullable = false)
    private Double duration;

    @Column(name = "DURATION_TYPE", columnDefinition = "enum('MINUTE','HOUR', 'MONTH', 'YEAR') DEFAULT 'YEAR'")
    @Enumerated(EnumType.STRING)
    private DurationType durationType;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<CourseSubject> subjects;

}