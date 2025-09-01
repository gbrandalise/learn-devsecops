package com.neo.learn.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.neo.learn"})
public class LearnDevSecOpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnDevSecOpsApplication.class, args);
	}

}
