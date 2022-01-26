package com.nepalaya.up.config;

import lombok.extern.slf4j.Slf4j;
import org.passay.PasswordGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class AppConfig {
    @Bean
    public PasswordGenerator passwordGenerator(){
        return new PasswordGenerator();
    }

}
