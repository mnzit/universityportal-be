package com.nepalaya.up.controller;

import com.nepalaya.up.constant.ApiConstant;
import com.nepalaya.up.constant.RoleAuthorityConstant;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.request.CreateUserRequest;
import com.nepalaya.up.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(ApiConstant.PROFILE)
    public Response currentUser() {
        return userService.currentUser();
    }

    @PostMapping(ApiConstant.USERS)
    @PreAuthorize(RoleAuthorityConstant.CREATE_USER)
    public Response create(@RequestBody @Valid CreateUserRequest request) {
        return userService.save(request);
    }

    @GetMapping(ApiConstant.USERS)
    @PreAuthorize(RoleAuthorityConstant.VIEW_USER)
    public Response users() {
        return userService.getAll();
    }

    @GetMapping(ApiConstant.USER)
    @PreAuthorize(RoleAuthorityConstant.VIEW_USER)
    public Response findUserByEmail(@RequestParam("email") String email) {
        return userService.getUser(email);
    }
}
