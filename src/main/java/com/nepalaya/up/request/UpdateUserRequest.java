package com.nepalaya.up.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class UpdateUserRequest implements Serializable {

    @NotNull
    private Long id;

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
    private Long roleId;
}
