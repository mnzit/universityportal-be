package com.nepalaya.up.service.impl;

import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.builder.UserBuilder;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.exception.SystemException;
import com.nepalaya.up.exception.DataNotFoundException;
import com.nepalaya.up.mapper.UserMapper;
import com.nepalaya.up.model.User;
import com.nepalaya.up.repository.UserRepository;
import com.nepalaya.up.request.CreateUserRequest;
import com.nepalaya.up.response.UserResponse;
import com.nepalaya.up.service.UserService;
import com.nepalaya.up.util.LogUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserBuilder userBuilder;

    public UserServiceImpl(UserRepository userRepository, UserBuilder userBuilder) {
        this.userRepository = userRepository;
        this.userBuilder = userBuilder;
    }

    @Transactional
    @Override
    public Response save(CreateUserRequest request) {
        try {
            User user = userBuilder.buildForCreate(request);
            userRepository.save(user);
            return ResponseBuilder.success("User created Successfully");
        } catch (Exception exception) {
            LogUtil.exception("Failed while saving User");
            throw new SystemException();
        }
    }


    @Override
    public Response getAll() {
        try {
            List<User> users = userRepository.findAll();
            List<UserResponse> data = UserMapper.mapUsers(users);
            if (!data.isEmpty()) {
                return ResponseBuilder.success("Users fetched Successfully", data);
            }
            return ResponseBuilder.failure("Users not found");
        } catch (Exception exception) {
            LogUtil.exception("Failed while fetching Users");
            throw new SystemException();
        }
    }

    @Override
    public Response currentUser() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserResponse data = UserMapper.mapUser((User) authentication.getPrincipal());
            return ResponseBuilder.success("User fetched Successfully", data);
        } catch (Exception exception) {
            LogUtil.exception("Failed while fetching User");
            throw new SystemException();
        }
    }

    @Override
    public Response getUser(String email) {
        try {
            User user = userRepository
                    .findByEmailAddress(email)
                    .orElseThrow(() -> new DataNotFoundException(String.format("User not found with email %s", email)));
            UserResponse data = UserMapper.mapUser(user);
            return ResponseBuilder.success("User fetched Successfully", data);
        } catch (Exception exception) {
            LogUtil.exception("Failed while fetching User");
            throw new SystemException();
        }
    }
}
