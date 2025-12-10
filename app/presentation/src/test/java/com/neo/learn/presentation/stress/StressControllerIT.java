package com.neo.learn.presentation.stress;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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
import com.neo.learn.presentation.stress.memory.StressMemoryService;

import jakarta.servlet.ServletException;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class StressControllerIT {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    StressCpuService stressCpuService;

    @MockitoBean
    StressMemoryService stressMemoryService;

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
        assert(elapsed < 10000);
        verify(stressCpuService, times(1)).test();
    }

    @Test
    @DisplayName("Deve retornar 200 e body com caminho do index ao chamar /stress/memory e não chamar CPU")
    void shouldReturnOkAndIndexPathOnMemory() throws Exception {
        MvcResult result = mockMvc.perform(get("/stress/memory")).andReturn();
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        assertEquals("/index.html", result.getResponse().getForwardedUrl());
        verify(stressMemoryService, times(1)).test();
        verify(stressCpuService, times(0)).test();
    }

    @Test
    @DisplayName("Deve propagar exceção como 500 se StressMemoryService lançar RuntimeException")
    void shouldReturn500IfMemoryServiceThrows() throws Exception {
        doThrow(new RuntimeException("boom-mem")).when(stressMemoryService).test();
        assertThrows(ServletException.class, () -> mockMvc.perform(get("/stress/memory")).andReturn());
        verify(stressMemoryService, times(1)).test();
        verify(stressCpuService, times(0)).test();
    }

    @Test
    @DisplayName("Deve não chamar StressMemoryService ao acessar /stress/cpu")
    void shouldNotInvokeMemoryOnCpu() throws Exception {
        mockMvc.perform(get("/stress/cpu")).andReturn();
        verify(stressCpuService, times(1)).test();
        verify(stressMemoryService, times(0)).test();
    }

    @Test
    @DisplayName("Deve retornar 405 (Method Not Allowed) para POST em /stress/cpu")
    void shouldReturn405OnPostCpu() throws Exception {
        MvcResult result = mockMvc.perform(post("/stress/cpu")).andReturn();
        assertEquals(HttpStatus.METHOD_NOT_ALLOWED.value(), result.getResponse().getStatus());
    }

    @Test
    @DisplayName("Deve retornar 404 para rota inexistente /stress/disk")
    void shouldReturn404OnUnknownPath() throws Exception {
        MvcResult result = mockMvc.perform(get("/stress/disk")).andReturn();
        assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());
    }
}
