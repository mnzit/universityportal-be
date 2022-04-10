package com.nepalaya.up.mapper;

import com.nepalaya.up.model.User;
import com.nepalaya.up.response.UserListResponse;
import com.nepalaya.up.response.UserResponse;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserListResponse mapUserList(User user) {
        UserListResponse response = new UserListResponse();
        response.setId(user.getId());
        response.setFirstName(user.getFirstName());
        response.setMiddleName(user.getMiddleName());
        response.setLastName(user.getLastName());
        response.setGenderType(user.getGenderType().name());
        response.setEmailAddress(user.getEmailAddress());
        response.setAddress(user.getAddress());
        response.setContactNo(user.getContactNo());
        response.setPassword(user.getPassword());
        response.setRole(user.getRole().getName());
        response.setAuthorities(user.authorities());
        return response;
    }

    public static List<UserListResponse> mapUsers(List<User> users) {
        return users
                .stream()
                .filter(User::getStatus)
                .map(UserMapper::mapUserList)
                .collect(Collectors.toList());
    }

    public static UserResponse mapUser(User user){
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setFirstName(user.getFirstName());
        response.setMiddleName(user.getMiddleName());
        response.setLastName(user.getLastName());
        response.setGenderType(user.getGenderType().name());
        response.setEmailAddress(user.getEmailAddress());
        response.setAddress(user.getAddress());
        response.setContactNo(user.getContactNo());
        response.setRoleId(user.getRole().getId());
        return response;

    }
}
