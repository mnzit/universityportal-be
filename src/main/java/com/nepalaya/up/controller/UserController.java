package com.nepalaya.up.controller;

import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.constant.RoleAuthorityConstant;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.model.User;
import com.nepalaya.up.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public User userDetail(@AuthenticationPrincipal User user){
        return user;
    }

    @PostMapping
    @PreAuthorize(RoleAuthorityConstant.CREATE_USER)
    public Response createUser(){
        return ResponseBuilder.success("Works");
    }
}
