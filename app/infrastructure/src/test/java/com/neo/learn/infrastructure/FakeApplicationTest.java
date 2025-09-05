package com.neo.learn.infrastructure;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class FakeApplicationTest {

	@Test
	void testInstance() {
		assertNotNull(new FakeApplication());
	}

}
