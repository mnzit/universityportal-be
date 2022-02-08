package com.nepalaya.up.config;

import lombok.extern.slf4j.Slf4j;
import org.passay.PasswordGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableAspectJAutoProxy
@EnableScheduling
@Configuration
public class AppConfig {

//    private final BookDetailRepository bookDetailRepository;
//
//    public AppConfig(BookDetailRepository bookDetailRepository) {
//        this.bookDetailRepository = bookDetailRepository;
//    }

    @Bean
    public PasswordGenerator passwordGenerator(){
        return new PasswordGenerator();
    }


//    @Scheduled(fixedDelay = 10000)
//    public void test(){
//        BookDetail bookDetail = new BookDetail();
//        bookDetail.setIsbn(100000L);
//        bookDetail.setAuthor("Test");
//        bookDetail.setPublishedDate(new Date());
//        bookDetail.setTitle("My Books");
//        bookDetailRepository.save(bookDetail);
//    }
}
