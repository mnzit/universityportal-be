package com.nepalaya.up.controller;

import com.nepalaya.up.constant.ApiConstant;
import com.nepalaya.up.constant.RoleAuthorityConstant;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.request.CreateUserRequest;
import com.nepalaya.up.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * localhost:8080/UniversityPortal/users GET
 * localhost:8080/UniversityPortal/users POST
 * localhost:8080/UniversityPortal/users/search?email=manjit@gmail.com GET
 */

@RestController
@RequestMapping(ApiConstant.USERS)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @PreAuthorize(RoleAuthorityConstant.CREATE_USER)
    public Response create(@RequestBody @Valid CreateUserRequest request) {
        return userService.save(request);
    }

    @GetMapping
    @PreAuthorize(RoleAuthorityConstant.VIEW_USER)
    public Response users() {
        return userService.getAll();
    }

    @GetMapping(ApiConstant.SEARCH)
    @PreAuthorize(RoleAuthorityConstant.VIEW_USER)
    public Response findUserByEmail(@RequestParam String email) {
        return userService.getUser(email);
    }
}
