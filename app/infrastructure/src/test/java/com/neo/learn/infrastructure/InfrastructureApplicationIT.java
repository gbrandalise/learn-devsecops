package com.neo.learn.infrastructure;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InfrastructureApplicationIT {

	@Autowired
	InfrastructureApplication app;

	@Test
	void testAppInstance() {
		assertNotNull(app);
	}

	@Test
	void testMainCall() {
		assertDoesNotThrow(() -> InfrastructureApplication.main(new String[0]));
	}

}
