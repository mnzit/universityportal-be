package com.nepalaya.up.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Getter
@Setter
public class CreateUserRequest implements Serializable {
    @Min(3)
    @Max(100)
    @Pattern(regexp="[a-zA-Z]")
    private String firstName;
    @Min(3)
    @Max(100)
    @Pattern(regexp="[a-zA-Z]")
    private String middleName;
    @Min(3)
    @Max(100)
    @Pattern(regexp="[a-zA-Z]")
    private String lastName;
    @Pattern(regexp="MALE|FEMALE")
    private String genderType;
    @Min(3)
    @Max(250)
    private String address;
    @Min(3)
    @Max(10)
    private String contactNo;
    @Email
    private String emailAddress;
    private Boolean sendEmail;
    private Boolean isPasswordGenerated;
    @Max(150)
    private String password;
    private Long roleId;
}
