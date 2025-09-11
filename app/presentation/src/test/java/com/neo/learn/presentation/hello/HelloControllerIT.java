package com.neo.learn.presentation.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class HelloControllerIT {

	@Autowired
	MockMvc mockMvc;

	@ParameterizedTest
	@ValueSource(strings = {"Test", "Test2", "Test3"})
	void testGreetings(String name) throws Exception {
		String result = mockMvc.perform(get("/greetings/{name}", name))
				.andReturn()
				.getResponse()
				.getContentAsString();
		assertEquals("Hello %s".formatted(name), result);
	}

	@Test
	void testGreetingsById() throws Exception {
		Long id = 1L;
		String name = "Test";
		String result = mockMvc.perform(get("/greetings/by-id/{id}", id))
				.andReturn()
				.getResponse()
				.getContentAsString();
		assertEquals("Hello %s".formatted(name), result);
	}

}
