package com.neo.learn.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.neo.learn")
@EnableJpaRepositories(basePackages = "com.neo.learn")
@EntityScan(basePackages = "com.neo.learn")
public class PresentationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PresentationApplication.class, args);
	}

}
