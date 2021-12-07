package com.nepalaya.up.config;

import com.nepalaya.up.model.Gender;
import com.nepalaya.up.model.User;
import com.nepalaya.up.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Date;
import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AuditingConfig {

    private final UserRepository userRepository;

    public AuditingConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public AuditorAware<User> auditorAware() {
        return () -> Optional.of(userRepository.getById(2L));
    }
}
