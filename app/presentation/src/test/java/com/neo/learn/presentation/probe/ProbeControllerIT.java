package com.neo.learn.presentation.probe;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;

import lombok.SneakyThrows;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProbeControllerIT {

	@Autowired
	MockMvc mockMvc;

	@Test
	@SneakyThrows
	void testLivenessUp() {
		mockMvc.perform(get("/probe/liveness/up"));

		mockMvc.perform(get("/actuator/health/liveness"))
			.andExpect(jsonPath("$.status").value("UP"));
	}

	@Test
	@SneakyThrows
	void testLivenessDown() {
		mockMvc.perform(get("/probe/liveness/down"));

		mockMvc.perform(get("/actuator/health/liveness"))
			.andExpect(jsonPath("$.status").value("DOWN"));
	}

	@Test
	@SneakyThrows
	void testReadinessUp() {
		mockMvc.perform(get("/probe/readiness/up"));

		mockMvc.perform(get("/actuator/health/readiness"))
			.andExpect(jsonPath("$.status").value("UP"));
	}

	@Test
	@SneakyThrows
	void testReadinessDown() {
		mockMvc.perform(get("/probe/readiness/down"));

		mockMvc.perform(get("/actuator/health/readiness"))
			.andExpect(jsonPath("$.status").value("OUT_OF_SERVICE"));
	}

}
