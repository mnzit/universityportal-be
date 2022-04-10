package com.nepalaya.up.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.io.Serializable;

@Getter
@Setter
public class CreateUserRequest implements Serializable {

    @NotEmpty
    private String firstName;

    private String middleName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String genderType;

    @NotEmpty
    private String address;

    @NotEmpty
    private String contactNo;
    @Email
    private String emailAddress;
    private Boolean sendEmail;
    private Boolean isPasswordGenerated;
    private String password;
    private Long roleId;
}
