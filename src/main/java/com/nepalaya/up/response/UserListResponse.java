package com.nepalaya.up.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class UserListResponse implements Serializable {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String genderType;
    private String address;
    private String contactNo;
    private String emailAddress;
    private String password;
    private String role;
    private List<String> authorities;
}
