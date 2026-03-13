package com.neo.learn.presentation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApplicationIT {

	@Autowired
	Application app;

	@Test
	void shouldCreateApplication() {
		assertNotNull(app);
	}

	@Test
	void shouldStartApplication_whenArgsIsEmpty() {
		assertDoesNotThrow(() -> Application.main()); // using default server.port=8080
	}

	@Test
	void shouldRunJob() {
		assertDoesNotThrow(() -> Application.main("job"));
	}

	@Test
	void shouldRunApplication() {
		assertDoesNotThrow(() -> Application.main("app", "--server.port=0"));
	}

}
