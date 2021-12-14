package com.nepalaya.up.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Timer;

    @Entity
    @Table(name = "ATTENDANCES")
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    class Attendance extends BaseEntity<User> {

        @JsonBackReference
        @NotBlank
        @Size(min = 2, max = 150)
        @ManyToOne
        @Basic(optional = false)
        @JoinColumn(name = "PROGRAM_ID", referencedColumnName = "ID")
        private Program program;

        @JsonBackReference
        @NotBlank
        @Size(min = 2, max = 150)
        @ManyToOne
        @Basic(optional = false)
        @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
        private User user;

        @Basic(optional = true)
        @Column(name = "STATE", columnDefinition = "enum('PRESENT','ABSENT', 'SICK', 'LEAVE') DEFAULT 'PRESENT'")
        @Enumerated(EnumType.STRING)
        private BookStatus state;
    }

