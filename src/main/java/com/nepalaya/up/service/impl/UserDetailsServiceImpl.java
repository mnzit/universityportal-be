package com.nepalaya.up.service.impl;

import com.nepalaya.up.constant.ResponseMsgConstant;
import com.nepalaya.up.model.User;
import com.nepalaya.up.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository
                .findByEmailAddress(email)
                .orElseThrow(() -> new UsernameNotFoundException(ResponseMsgConstant.LOGIN_FAILED));
        if (!user.getStatus()) {
            throw new UsernameNotFoundException(ResponseMsgConstant.LOGIN_FAILED);
        }
        return user;
    }
}
