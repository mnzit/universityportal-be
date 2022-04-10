package com.nepalaya.up.service.impl;

import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.builder.UserBuilder;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.exception.DataNotFoundException;
import com.nepalaya.up.exception.SystemException;
import com.nepalaya.up.mapper.UserMapper;
import com.nepalaya.up.model.User;
import com.nepalaya.up.repository.UserRepository;
import com.nepalaya.up.request.CreateUserRequest;
import com.nepalaya.up.request.UpdateUserRequest;
import com.nepalaya.up.response.UserListResponse;
import com.nepalaya.up.response.UserResponse;
import com.nepalaya.up.service.UserService;
import com.nepalaya.up.util.LogUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.nepalaya.up.constant.ExceptionConstant.DATA_NOT_FOUND;
import static com.nepalaya.up.constant.ExceptionConstant.SYSTEM_EXCEPTION;

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
            List<UserListResponse> data = UserMapper.mapUsers(users);
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
            UserListResponse data = UserMapper.mapUserList((User) authentication.getPrincipal());
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
            UserListResponse data = UserMapper.mapUserList(user);
            return ResponseBuilder.success("User fetched Successfully", data);
        } catch (Exception exception) {
            LogUtil.exception("Failed while fetching User");
            throw new SystemException();
        }
    }


    @Override
    public Response deleteUser(Long id) {
        try {
            User user = userRepository
                    .findById(id)
                    .orElseThrow(DATA_NOT_FOUND.apply("User not found"));
            user.setStatus(false);
            userRepository.save(user);
            return ResponseBuilder.success("User Deleted Successfully");
        } catch (Exception ex) {
            throw SYSTEM_EXCEPTION.apply(null).get();
        }
    }

    @Override
    public Response getById(Long id) {
        try {
            User user = userRepository
                    .findById(id)
                    .orElseThrow(DATA_NOT_FOUND.apply("User not found"));
            UserResponse response = UserMapper.mapUser(user);
            return ResponseBuilder.success("User Fetched Successfully", response);
        } catch (Exception ex) {
            throw SYSTEM_EXCEPTION.apply(null).get();
        }
    }

    @Override
    @Transactional
    public Response update(UpdateUserRequest request) {
        try {
            User user = userRepository
                    .findById(request.getId())
                    .orElseThrow(DATA_NOT_FOUND.apply("User not found"));

            user = userBuilder.buildForUpdate(request, user);
            userRepository.save(user);
            return ResponseBuilder.success("User updated Successfully");
        } catch (Exception exception) {
            LogUtil.exception("Failed while updating User");
            throw new SystemException();
        }
    }
}
