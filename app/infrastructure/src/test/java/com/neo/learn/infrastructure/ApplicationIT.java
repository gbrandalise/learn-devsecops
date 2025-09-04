package com.neo.learn.infrastructure;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationIT {

	@Autowired
	Application app;

	@Test
	void testAppInstance() {
		assertNotNull(app);
	}

	@Test
	void testMainCall() {
		Application.main(new String[0]);
	}

}
