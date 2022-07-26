package com.michal.Spring_Mongo_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringMongoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoAppApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepo repo) {
		return args -> {
			Address address = new Address("Poland", "Warsaw", "00-001");
			String phoneNumber = "za";
			Student student = new Student(
					"John",
					"Smith",
					phoneNumber,
					Gender.MALE,
					address,
					List.of("History"),
					LocalDateTime.now()
			);


			repo.findStudentByPhoneNumber(phoneNumber)
					.ifPresentOrElse(s -> System.out.println(s + " already exist"), () -> {
						System.out.println("Inserting student " + student);
						repo.insert(student);


					});




		};



	}












}
