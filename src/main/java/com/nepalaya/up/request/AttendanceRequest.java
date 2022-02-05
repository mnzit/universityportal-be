package com.nepalaya.up.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter

public class AttendanceRequest {
    @NotBlank
    @Email
    private String emailAddress;
    @NotBlank
    private String password;
}
