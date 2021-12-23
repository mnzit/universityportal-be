package com.nepalaya.up.service;

import com.nepalaya.up.dto.Response;
import com.nepalaya.up.request.CreateUserRequest;

public interface UserService {

    Response currentUser();

    Response save(CreateUserRequest request);

    Response getUser(String email);

    Response getAll();
}
