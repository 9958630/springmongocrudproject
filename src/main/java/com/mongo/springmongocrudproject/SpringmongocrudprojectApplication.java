package com.mongo.springmongocrudproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mongo.*")
public class SpringmongocrudprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmongocrudprojectApplication.class, args);
	}

}
