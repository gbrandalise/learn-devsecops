package com.neo.learn.presentation.stress;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.neo.learn.presentation.stress.cpu.StressCpuService;

import jakarta.servlet.ServletException;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class StressControllerIT {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    StressCpuService stressCpuService;

    @Test
    @DisplayName("Deve retornar 200 e body com caminho do index ao chamar /stress/cpu")
    void shouldReturnOkAndIndexPathOnCpu() throws Exception {
        MvcResult result = mockMvc.perform(get("/stress/cpu")).andReturn();
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        assertEquals("/index.html", result.getResponse().getForwardedUrl());
        verify(stressCpuService, times(1)).test();
    }

    @Test
    @DisplayName("Deve propagar exceção como 500 se StressCpuService lançar RuntimeException")
    void shouldReturn500IfServiceThrows() throws Exception {
        doThrow(new RuntimeException("boom")).when(stressCpuService).test();
        assertThrows(ServletException.class, () -> mockMvc.perform(get("/stress/cpu")).andReturn());
        verify(stressCpuService, times(1)).test();
    }

    @Test
    @DisplayName("Deve não bloquear a thread de requisição (tempo de resposta razoável)")
    void shouldRespondQuickly() throws Exception {
        // Não configure comportamento especial; como o método retorna String imediatamente,
        // a resposta não deve demorar.
        long start = System.currentTimeMillis();
        mockMvc.perform(get("/stress/cpu")).andReturn();
        long elapsed = System.currentTimeMillis() - start;
        // 1 segundo é um limite razoável para o ambiente de CI
        assert(elapsed < 1000);
        verify(stressCpuService, times(1)).test();
    }
}
