package com.nepalaya.up.service.impl;

import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.mapper.RoleMapper;
import com.nepalaya.up.model.Role;
import com.nepalaya.up.repository.RoleRepository;
import com.nepalaya.up.response.RoleResponse;
import com.nepalaya.up.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Response getRoleById(Long id) {
        Response response = null;
        Optional<Role> optionalRole = roleRepository.findById(id);
        if(optionalRole.isPresent()){
            Role role = optionalRole.get();
            //Mapping
            RoleResponse roleResponse = RoleMapper.mapRole(role);
            response = ResponseBuilder.success("Role fetched successfully!", roleResponse);
        }else{
            response = ResponseBuilder.failure("Role not found");
        }
        return response;
    }
}
