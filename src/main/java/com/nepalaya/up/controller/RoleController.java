package com.nepalaya.up.controller;

import com.nepalaya.up.dto.Response;
import com.nepalaya.up.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("{id}")
    public Response role(@PathVariable("id") Long id){
        return roleService.getRoleById(id);
    }

}
