package com.nepalaya.up.config;

import com.nepalaya.up.model.User;
import com.nepalaya.up.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class AuditingConfig {

    private final UserRepository userRepository;

    public AuditingConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public AuditorAware<User> auditorAware() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        if(authentication == null || !authentication.isAuthenticated()){
            // Fix for schedulers case as schedulers don't have any session
            return () -> Optional.of(userRepository.getById(1L));
        }
        // Logged in user session
        return () -> Optional.of((User) authentication.getPrincipal());
    }
}
