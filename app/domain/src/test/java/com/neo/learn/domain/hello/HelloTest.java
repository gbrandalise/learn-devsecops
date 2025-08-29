package com.neo.learn.domain.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
class HelloTest {

	@Test
	void test_instance() {
		var entity = new Hello(1L, "Name");
		assertNotNull(entity);
	}

	@Test
	void test_greetings_with_name() {
		var result = Hello.greetings("Test");
		assertEquals("Hello Test", result);
	}

	@Test
	void test_greetings_with_null() {
		var result = Hello.greetings(null);
		assertEquals("Hello null", result);
	}

	@Test
	void test_greetings_by_id() {
		Long id = 1L;
		var entity = new Hello(id, "Test");
		var result = entity.greetings();
		assertEquals("Hello Test", result);
	}

}
