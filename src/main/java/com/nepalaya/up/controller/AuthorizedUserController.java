package com.nepalaya.up.controller;

import com.nepalaya.up.constant.ApiConstant;
import com.nepalaya.up.constant.RoleAuthorityConstant;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * localhost:8080/UniversityPortal/profile GET
 */
@RestController
public class AuthorizedUserController {

    private final UserService userService;

    public AuthorizedUserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize(RoleAuthorityConstant.AUTHORIZED)
    @GetMapping(ApiConstant.PROFILE)
    public Response currentUser() {
        return userService.currentUser();
    }
}
