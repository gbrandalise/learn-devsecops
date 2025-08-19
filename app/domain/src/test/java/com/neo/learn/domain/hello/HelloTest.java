package com.neo.learn.domain.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class HelloTest {

	@Test
	void test_instance() {
		var entity = new Hello();
		assertNotNull(entity);
	}

	@Test
	void test_greetings_with_name() {
		var entity = new Hello();
		var result = entity.greetings("Test");
		assertEquals("Olá Test\n", result);
	}

	@Test
	void test_greetings_with_null() {
		var entity = new Hello();
		var result = entity.greetings(null);
		assertEquals("Olá null\n", result);
	}

}
