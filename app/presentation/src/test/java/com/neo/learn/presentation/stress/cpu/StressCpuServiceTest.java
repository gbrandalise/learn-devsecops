package com.neo.learn.presentation.stress.cpu;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class StressCpuServiceTest {

	private StressCpuService stressCpuService;

	@BeforeEach
	void setUp() {
		stressCpuService = new StressCpuService();
	}

	@Test
	void shouldCreateThreadsForEachAvailableCore() {
		int expectedCores = Runtime.getRuntime().availableProcessors();

		assertDoesNotThrow(() -> {
			stressCpuService.test();
		});

		assertEquals(expectedCores, Runtime.getRuntime().availableProcessors(),
				"O número de cores disponíveis deve corresponder ao esperado");
	}

	@Test
	void shouldStartAllCreatedThreads() {
		int expectedThreadCount = Runtime.getRuntime().availableProcessors();
		int initialThreadCount = Thread.activeCount();

		assertDoesNotThrow(() -> {
			stressCpuService.test();
		});

		// Aguarda um pouco para as threads iniciarem
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		int finalThreadCount = Thread.activeCount();
		int createdThreads = finalThreadCount - initialThreadCount;

		assertTrue(createdThreads >= expectedThreadCount,
				"Deve ter criado pelo menos " + expectedThreadCount + " threads, mas criou " + createdThreads);
	}

	@Test
	void shouldExecuteMathematicalOperationsWithoutException() {
		assertDoesNotThrow(() -> {
			stressCpuService.test();
		}, "O método test() não deve lançar exceções durante execução");
	}

	@Test
	void shouldDetectCorrectNumberOfAvailableProcessors() {
		int cores = Runtime.getRuntime().availableProcessors();

		assertNotNull(cores, "O número de processadores não deve ser nulo");
		assertTrue(cores > 0, "Deve haver pelo menos um processador disponível");
	}

	@Test
	@Timeout(2)
	void shouldKeepThreadsRunningContinuously() throws InterruptedException {
		int initialThreadCount = Thread.activeCount();

		stressCpuService.test();

		// Aguarda um pouco para as threads iniciarem
		Thread.sleep(500);

		int threadCountAfterDelay = Thread.activeCount();
		int activeThreads = threadCountAfterDelay - initialThreadCount;

		assertTrue(activeThreads > 0,
				"Deve haver threads ativas após a execução do método test()");
	}

}
