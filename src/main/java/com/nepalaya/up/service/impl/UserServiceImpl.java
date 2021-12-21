package com.nepalaya.up.service.impl;

import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.builder.UserBuilder;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.model.User;
import com.nepalaya.up.repository.UserRepository;
import com.nepalaya.up.request.CreateUserRequest;
import com.nepalaya.up.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserBuilder userBuilder;

    public UserServiceImpl(UserRepository userRepository, UserBuilder userBuilder) {
        this.userRepository = userRepository;
        this.userBuilder = userBuilder;
    }

    @Override
    public Response saveUser(CreateUserRequest request) {
        User user = userBuilder.buildForCreate(request);
        userRepository.save(user);
        if(request.getSendEmail()){
            // TODO: Send email to the User
        }
        return ResponseBuilder.success("User created Successfully");
    }
}
