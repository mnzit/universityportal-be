package com.nepalaya.up.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class RoleListResponse implements Serializable {

    private List<Role> roles;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Role implements Serializable {
        private Long id;
        private String name;


    }
}
