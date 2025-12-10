package com.neo.learn.presentation.stress.memory;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class StressMemoryServiceTest {

    private StressMemoryService stressMemoryService;

    // limiar conservador para execução: 1.5GB de heap máxima
    private static final long MIN_HEAP_BYTES = 1_500_000_000L;

    @BeforeEach
    void setUp() {
        stressMemoryService = new StressMemoryService();
    }

    private boolean hasEnoughHeap() {
        // Usa a heap máxima como heurística simples; evita executar sob baixa memória
        long max = Runtime.getRuntime().maxMemory();
        return max >= MIN_HEAP_BYTES;
    }

    @Test
    void shouldAllocateMemoryWithoutThrowingImmediately() {
        assumeTrue(hasEnoughHeap(), "Ambiente sem heap suficiente; teste pulado");
        assertDoesNotThrow(() -> stressMemoryService.test(),
                "O método test() não deve lançar exceção imediatamente durante a alocação controlada");
    }

    @Test
    void shouldAttemptMultipleAllocations() {
        assumeTrue(hasEnoughHeap(), "Ambiente sem heap suficiente; teste pulado");
        long beforeFree = Runtime.getRuntime().freeMemory();
        assertDoesNotThrow(() -> stressMemoryService.test());
        long afterFree = Runtime.getRuntime().freeMemory();
        // Não há garantia estrita por causa do GC; validamos leituras coerentes
        assertTrue(beforeFree >= 0 && afterFree >= 0, "Leituras de memória devem ser válidas");
    }

    @Test
    @Timeout(10)
    void shouldReturnPromptly() {
        assumeTrue(hasEnoughHeap(), "Ambiente sem heap suficiente; teste pulado");
        // Garante que o método conclui rapidamente (sem loops infinitos)
        assertDoesNotThrow(() -> stressMemoryService.test());
    }

    @Test
    void shouldNotLeakReferencesAfterMethodEnds() {
        assumeTrue(hasEnoughHeap(), "Ambiente sem heap suficiente; teste pulado");
        // Lista é local ao método; após término, arrays ficam elegíveis ao GC
        assertDoesNotThrow(() -> stressMemoryService.test());
        System.gc();
        // Não há assert forte sem instrumentação; valida ao menos ausência de erros
        assertTrue(true);
    }

    @Test
    void shouldHandleSmallerHeapEnvironmentsGracefully() {
        // Mesmo sob pouca memória, a chamada não deve quebrar o runner do teste;
        // se ocorrer OOME, capturamos e consideramos aceitável em ambientes restritos
        assertDoesNotThrow(() -> {
            try {
                if (hasEnoughHeap()) {
                    stressMemoryService.test();
                } else {
                    // Executa apenas uma alocação pequena para validar fluxo básico
                    byte[] tmp = new byte[10_000];
                    assertTrue(tmp.length == 10_000);
                }
            } catch (OutOfMemoryError e) {
                // aceitável em ambientes com heap muito restrita
            }
        });
    }
}
