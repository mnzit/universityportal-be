package com.nepalaya.up.controller;

import com.nepalaya.up.model.Role;
import com.nepalaya.up.repository.RoleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("roles")
public class RoleController {

    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping("{id}")
    public Role role(@PathVariable("id") Long id){
        Optional<Role> role = roleRepository.findById(id);
        return role.get();
    }

}
