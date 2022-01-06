package com.nepalaya.up.model;

import com.nepalaya.up.model.enums.AttendanceState;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_ATTENDANCES")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attendance extends BaseEntity<User> {

    @ManyToOne
    @JoinColumn(name = "PROGRAM_ID", referencedColumnName = "ID")
    private Program program;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    @Column(name = "STATE", columnDefinition = "enum('PRESENT','ABSENT', 'SICK', 'LEAVE') DEFAULT 'PRESENT'")
    @Enumerated(EnumType.STRING)
    private AttendanceState state;
}