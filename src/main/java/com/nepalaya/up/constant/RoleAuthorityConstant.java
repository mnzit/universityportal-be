package com.nepalaya.up.constant;

public interface RoleAuthorityConstant {
    // Roles
    String SUPER_ADMIN = "hasRole('SUPER_ADMIN')";

    // Authorities
    String CREATE_USER = "hasAuthority('ADD_USER')";
    String VIEW_USER = "hasAuthority('VIEW_USER')";
    String AUTHORIZED = "isAuthenticated()";


}
