package com.nepalaya.up;

import com.nepalaya.up.model.Gender;
import com.nepalaya.up.model.User;
import com.nepalaya.up.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class UpApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(UserRepository userRepository) {
		return (args) -> {
			User user = new User();

			user.setFirstName("Anita");
			user.setLastName("Joshi");
			user.setAddress("Nepal");
			user.setGender(Gender.FEMALE);
			user.setContactNo("980XXXXXXX");
			user.setEmailAddress("anitajoc@gmail.com");
			user.setPassword("password1");
			userRepository.save(user);
			Thread.sleep(10000)
			user.setFirstName("Anitas");
			userRepository.save(user);
		};
	}

}
