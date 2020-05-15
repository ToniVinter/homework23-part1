package com.fasttrackit.homeWork23part1;

import com.fasttrackit.homeWork23part1.domain.Vacation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomeWork23Part1Application {

	public static void main(String[] args) {
		SpringApplication.run(HomeWork23Part1Application.class, args);
	}

	@Bean
	CommandLineRunner atStartup(VacationRepository repo) {
		return args -> {
			repo.save(new Vacation("Black Eagle", 20, 100));
			repo.save(new Vacation("Paris", 2000, 10));

			repo.findAll()
					.forEach(System.out::println);
		};
	}
}
