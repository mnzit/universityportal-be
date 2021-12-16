package com.nepalaya.up.manager;

import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.model.User;
import com.nepalaya.up.request.LoginRequest;
import com.nepalaya.up.response.LoginResponse;
import com.nepalaya.up.util.JwtUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class LoginManager {

    private final UserDetailsService userDetailsService;

    public LoginManager(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public Response login(LoginRequest request) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmailAddress());
        String requestPassword = request.getPassword();
        String savedPassword = userDetails.getPassword();
        User user = (User) userDetails;

        if (requestPassword.equals(savedPassword)) {
            String token = JwtUtil.generateToken(userDetails);
            LoginResponse data = new LoginResponse(new StringBuilder()
                    .append(user.getFirstName())
                    .append(" ")
                    .append(user.getLastName())
                    .toString(), user.getEmailAddress(),token);
            return ResponseBuilder.success("Login Successful", data);
        } else {
            return ResponseBuilder.failure("Email/Password is incorrect");
        }
    }
}
