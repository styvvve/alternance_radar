package com.alternanceradar;

import com.alternanceradar.entity.User;
import com.alternanceradar.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class AlternanceRadarApplication {

	public static void main(String[] args) {

		SpringApplication.run(AlternanceRadarApplication.class, args);
	}

	/*@Bean
	CommandLineRunner testUserRepository(UserRepository userRepository) {
		return args -> {
			User newUser = new User("Test", "User", "test-test@gmail.com", "testeur");

			User savedUser = userRepository.save(newUser);

			System.out.println("User saved with id: " + savedUser.getId());

			Optional<User> foundUser = userRepository.findById(savedUser.getId());

			foundUser.ifPresent(user -> System.out.println("User found with id: " + user.getId()));
		};
	}*/

}
