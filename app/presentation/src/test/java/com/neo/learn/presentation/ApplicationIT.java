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
	void shouldStartApplication() {
		assertDoesNotThrow(() -> Application.main(new String[0]));
	}

}
