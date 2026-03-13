package com.neo.learn.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.neo.learn")
@EnableJpaRepositories(basePackages = "com.neo.learn")
@EntityScan(basePackages = "com.neo.learn")
public class Application {

	public static void main(String... args) {
		String runner = "app";
		if (args.length > 0) {
			runner = args[0];
		}
		switch (runner) {
			case "job" -> runJob();
			default -> SpringApplication.run(Application.class, args);
		}
	}

	private static void runJob() {
		System.out.println("Job executed successfully");
	}

}
