package com.neo.learn.presentation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LearnDevSecOpsApplicationIT {

	@Autowired
	LearnDevSecOpsApplication app;

	@Test
	void shouldCreateApplication() {
		assertNotNull(app);
	}

	@Test
	void shouldStartApplication() {
		assertDoesNotThrow(() -> LearnDevSecOpsApplication.main(new String[0]));
	}

}
