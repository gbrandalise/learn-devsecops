package com.neo.learn.infrastructure.hello.jpa;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.neo.learn.application.hello.HelloRepository;
import com.neo.learn.domain.hello.Hello;

@SpringBootTest(classes = HelloRepositoryIT.AppConfig.class)
class HelloRepositoryIT {

	@Configuration
	@EnableAutoConfiguration
	@ComponentScan(basePackages = "com.neo.learn.infrastructure")
	public static class AppConfig {
	}

	@Autowired
	HelloRepository repository;

	@Test
	void testInsertHello() {
		Long id = 1L;
		Optional<Hello> entity = repository.findById(id);
		assertTrue(entity.isPresent());
	}

}
