package com.neo.learn.infrastructure.jpa.hello;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neo.learn.application.hello.HelloRepository;
import com.neo.learn.domain.hello.Hello;

@SpringBootTest
class HelloRepositoryIT {

	@Autowired
	HelloRepository repository;

	@Test
	void testInsertHello() {
		Long id = 1L;
		Optional<Hello> entity = repository.findById(id);
		assertTrue(entity.isPresent());
	}

}
