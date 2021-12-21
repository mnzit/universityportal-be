package com.nepalaya.up.service;

import com.nepalaya.up.dto.Response;
import com.nepalaya.up.request.CreateUserRequest;

public interface UserService {

    Response saveUser(CreateUserRequest request);
}
