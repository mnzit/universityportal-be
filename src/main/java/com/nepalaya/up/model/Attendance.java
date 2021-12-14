package com.nepalaya.up.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.logging.Filter;

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
        private AttendanceState state;

//        prerequirement
//        1. ROLE
//        2. AUTHORITY
//
//        1. LOGIN
//        2. LOGOUT
//        3. JWT - JWS - JWE
//        4. Authentication Token
//        5. Spring Security
//        6. Filter

    // repo, scrap holiday, minio- course subject nabin
    // service,scrap holiday, minio bookhistory - anita
    // repo,scrap holiday attendance,minio program- nawaraj
    // service,scrap holiday, minio bookdetail - sapana

    }

