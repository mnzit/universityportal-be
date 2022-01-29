package com.nepalaya.up.model;

import com.nepalaya.up.model.enums.AttendanceState;
import lombok.*;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

@Entity
@Table(name = "ATTENDANCES")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attendance extends BaseEntity<User> {

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    @Column(name = "STATE")
    @Enumerated(EnumType.STRING)
    @org.hibernate.annotations.Generated(GenerationTime.INSERT)
    private AttendanceState state = AttendanceState.PRESENT;
}