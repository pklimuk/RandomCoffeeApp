package com.pklimuk.RandomCoffee;

import com.pklimuk.RandomCoffee.model.User;
import com.pklimuk.RandomCoffee.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.pklimuk.RandomCoffee.enumeration.Role.USER;

@SpringBootApplication
public class RandomCoffeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandomCoffeeApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepository userRepository) {
		return args -> {
			userRepository.save(new User(null, "Peter", "Carrick", "pcarrick@gamil.com",
					"http://localhost:8080/server/image/defaultUserImage.png", USER));
			userRepository.save(new User(null, "Ann", "Smith", "asmith@gamil.com",
					"http://localhost:8080/server/image/defaultUserImage.png", USER));
			userRepository.save(new User(null, "John", "Evans", "jevans@gamil.com",
					"http://localhost:8080/server/image/defaultUserImage.png", USER));
			userRepository.save(new User(null, "Simona", "Wales", "swales@gamil.com",
					"http://localhost:8080/server/image/defaultUserImage.png", USER));
		};
	}

}
