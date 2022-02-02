package com.nepalaya.up.config;

import com.nepalaya.up.util.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.passay.PasswordGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@EnableScheduling
@Configuration
public class AppConfig {

    @Bean
    public PasswordGenerator passwordGenerator(){
        return new PasswordGenerator();
    }


    @Scheduled(fixedDelay = 1000)
    public void test(){
        LogUtil.info("testing scheduler");
    }

}
