package com.nepalaya.up.service;

import com.nepalaya.up.dto.Response;
import com.nepalaya.up.request.CreateUserRequest;
import com.nepalaya.up.request.UpdateUserRequest;

public interface UserService {

    Response currentUser();

    Response save(CreateUserRequest request);

    Response getUser(String email);

    Response getAll();

    Response deleteUser(Long id);

    Response getById(Long id);

    Response update(UpdateUserRequest request);
}
