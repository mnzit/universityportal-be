package com.nepalaya.up.facade;

import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.callback.AuthCallback;
import com.nepalaya.up.constant.ResponseMsgConstant;
import com.nepalaya.up.constant.SecurityConstant;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.email.dto.EmailDTO;
import com.nepalaya.up.email.producer.EmailEventProducer;
import com.nepalaya.up.model.User;
import com.nepalaya.up.repository.UserRepository;
import com.nepalaya.up.request.LoginRequest;
import com.nepalaya.up.util.JwtUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LoginFacade {

    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final EmailEventProducer emailEventProducer;


    public LoginFacade(UserDetailsService userDetailsService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder, UserRepository userRepository, EmailEventProducer emailEventProducer) {
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.emailEventProducer = emailEventProducer;
    }

    public Response login(LoginRequest request, AuthCallback authCallback) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmailAddress());
        User user = (User) userDetails;
        if (!user.getStatus()) {
            return ResponseBuilder.failure(ResponseMsgConstant.ACCOUNT_BLOCKED);
        }
        String requestPassword = request.getPassword();
        String savedPassword = userDetails.getPassword();

        if (passwordEncoder.matches(requestPassword, savedPassword)) {
            // Generating token
            String token = jwtUtil.generateToken(userDetails);
            // Setting token in header
            HttpHeaders responseHeaders = new HttpHeaders();

            responseHeaders.set(
                    HttpHeaders.AUTHORIZATION, new StringBuilder()
                            .append(SecurityConstant.JWT_PREFIX)
                            .append(token)
                            .toString()
            );

            user.resetWrongPasswordAttemptCount();

            userRepository.save(user);

            authCallback.patch(responseHeaders);
            // Return response
            return ResponseBuilder.success(ResponseMsgConstant.LOGIN_SUCCESSFUL);
        } else {
            user.increaseWrongPasswordAttemptCount();
            userRepository.save(user);
            emailEventProducer.sendEmail(new EmailDTO(request.getEmailAddress(), "Wrong Password", String.format("You have entered a wrong password. You have %s attempt left.", User.TOTAL_WRONG_ATTEMPT_COUNT - user.getWrongPasswordAttemptCount())));
            if (!user.getStatus()) {
                return ResponseBuilder.failure(ResponseMsgConstant.ACCOUNT_BLOCKED);
            }
            return ResponseBuilder.failure(ResponseMsgConstant.LOGIN_FAILED);
        }
    }
}
