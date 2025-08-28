package com.neo.learn.domain.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class HelloTest {

	@Mock
	HelloRepository repository;

	Hello hello;

	@BeforeEach
	void setup() {
		hello = new Hello(repository);
	}

	@Test
	void test_instance() {
		var entity = new Hello(1L, "Name");
		assertNotNull(entity);
	}

	@Test
	void test_greetings_with_name() {
		var result = hello.greetings("Test");
		assertEquals("Hello Test", result);
	}

	@Test
	void test_greetings_with_null() {
		var result = hello.greetings(null);
		assertEquals("Hello null", result);
	}

	@Test
	void test_greetings_by_id() {
		Long id = 1L;
		when(repository.findById(id)).thenReturn(Optional.of(new Hello(id, "Test")));
		var result = hello.greetingsById(id);
		assertEquals("Hello Test", result);
	}

	@Test
	void test_greetings_by_id_not_found() {
		Long id = 1L;
		var result = hello.greetingsById(id);
		assertEquals("Hello null", result);
	}

}
