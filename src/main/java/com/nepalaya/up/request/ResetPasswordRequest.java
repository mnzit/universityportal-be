package com.nepalaya.up.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ResetPasswordRequest {

    @NotBlank
    private String newPassword;

    @NotBlank
    private String token;
}
