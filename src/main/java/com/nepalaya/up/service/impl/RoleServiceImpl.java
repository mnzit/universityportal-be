package com.nepalaya.up.service.impl;

import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.model.Role;
import com.nepalaya.up.repository.RoleRepository;
import com.nepalaya.up.response.RoleListResponse;
import com.nepalaya.up.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Response getAll() {

        List<Role> roles =  roleRepository.findAll();
        RoleListResponse response = new RoleListResponse();
        response.setRoles(roles.stream().map(role -> new RoleListResponse.Role(role.getId(), role.getName())).collect(Collectors.toList()));

        return ResponseBuilder.success("Roles fetched successfully!",response);
    }
}
