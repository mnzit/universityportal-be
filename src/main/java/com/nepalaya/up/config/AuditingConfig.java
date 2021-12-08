package com.nepalaya.up.config;

import com.nepalaya.up.model.Gender;
import com.nepalaya.up.model.User;
import com.nepalaya.up.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

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

        User user = new User();

        user.setFirstName("Anita");
        user.setLastName("Joshi");
        user.setAddress("Nepal");
        user.setGender(Gender.FEMALE);
        user.setContactNo("980XXXXXXX");
        user.setEmailAddress("anitajoc@gmail.com");
        user.setPassword("password1");

        return () -> Optional.of(user);
    }
}
