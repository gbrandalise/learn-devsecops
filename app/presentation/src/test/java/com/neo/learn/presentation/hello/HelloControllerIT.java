package com.neo.learn.presentation.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerIT {

	@Autowired
	MockMvc mockMvc;

	@ParameterizedTest
	@ValueSource(strings = {"Test", "Test2", "Test3"})
	void testGreeting(String name) throws Exception {
		String result = mockMvc.perform(get("/greetings/{name}", name))
				.andReturn()
				.getResponse()
				.getContentAsString();
		assertEquals("Hello %s\n".formatted(name), result);
	}

}
