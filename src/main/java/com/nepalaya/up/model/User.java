package com.nepalaya.up.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USERS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity<User> {

    @Basic(optional = true)
    @NotBlank
    @Size(min = 2, max = 150)
    @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;

    @Basic(optional = true)
    @NotBlank
    @Size(min = 2, max = 150)
    @Column(name = "MIDDLENAME", nullable = true)
    private String middleName;

    @Basic(optional = true)
    @NotBlank
    @Size(min = 2, max = 150)
    @Column(name = "LASTNAME", nullable = false)
    private String lastName;

    @Basic(optional = true)
    @NotBlank
    @Size(min = 2, max = 150)
    @Column(name = "GENDER", columnDefinition = "enum('MALE','FEMALE')", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Basic(optional = true)
    @NotBlank
    @Column(name = "ADDRESS", nullable = false)
    @Size(min = 2, max = 200)
    private String address;

    @NotBlank
    @Column(name = "CONTACT_NO", nullable = false)
    private String contactNo;

    @Basic(optional = true)
    @NotBlank
    @Column(name = "EMAIL_ADDRESS", nullable = false)
    @Size(min = 2, max = 200)
    @Email
    private String emailAddress;

    @Basic(optional = true)
    @NotBlank
    @Column(name = "PASSSWORD", nullable = false)
    @Size(min = 8, max = 100)
    private String password;

}
