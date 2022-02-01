package com.nepalaya.up.model;

import com.nepalaya.up.model.enums.AttendanceState;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenerationTime;
import javax.persistence.*;

@Entity
@Table(name = "ATTENDANCES")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@org.hibernate.annotations.Cache(region = "attendances", usage = CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
public class Attendance extends BaseEntity<User> {

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    @Column(name = "STATE", columnDefinition = "VARCHAR(100) DEFAULT 'PRESENT'")
    @Enumerated(EnumType.STRING)
    @org.hibernate.annotations.Generated(GenerationTime.INSERT)
    private AttendanceState state;
}