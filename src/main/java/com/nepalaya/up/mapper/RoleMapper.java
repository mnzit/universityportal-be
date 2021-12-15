package com.nepalaya.up.mapper;

import com.nepalaya.up.model.Role;
import com.nepalaya.up.response.RoleResponse;

import java.util.List;
import java.util.stream.Collectors;

public class RoleMapper {

    public static RoleResponse mapRole(Role role){
        RoleResponse roleResponse = new RoleResponse();

        roleResponse.setName(role.getName());

        List<String> authorities = role
                .getRoleAuthorities()
                .stream()
                .map(roleAuthority -> roleAuthority.getAuthority().getName())
                .collect(Collectors.toList());

        roleResponse.setAuthorities(authorities);

        return roleResponse;
    }
}
