package com.neo.learn.application.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.neo.learn.domain.hello.Hello;

@ExtendWith(MockitoExtension.class)
class GetGreetingsMessageByIdTest {

    @Mock
    private HelloRepository repository;

	@InjectMocks
    private GetGreetingsMessageById useCase;

    @Test
    void shouldReturnGreetingFromRepositoryWhenIdExists() {
        Long id = 1L;
		GreetingsMessageByIdRequest request = new GreetingsMessageByIdRequest(id);
        Hello entity = new Hello("Alice");
        when(repository.findById(id)).thenReturn(Optional.of(entity));

        GreetingsMessageResponse response = useCase.process(request);

        assertEquals(entity.greetings(), response.greetingsMessage());
    }

    @Test
    void shouldCallRepositoryFindByIdWithRequestIdOnce() {
        Long id = 42L;
		GreetingsMessageByIdRequest request = new GreetingsMessageByIdRequest(id);
        when(repository.findById(id)).thenReturn(Optional.of(new Hello("Bob")));

        useCase.process(request);

        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
        verify(repository, times(1)).findById(captor.capture());
        assertEquals(id, captor.getValue());
        verifyNoMoreInteractions(repository);
    }

    @Test
    void shouldReturnNewResponseInstanceOnEachCall() {
        Long id = 7L;
		GreetingsMessageByIdRequest request = new GreetingsMessageByIdRequest(id);
        Hello entity = new Hello("Carol");
        when(repository.findById(id)).thenReturn(Optional.of(entity));

        GreetingsMessageResponse first = useCase.process(request);
        GreetingsMessageResponse second = useCase.process(request);

        assertNotSame(first, second);
        assertEquals(entity.greetings(), first.greetingsMessage());
        assertEquals(entity.greetings(), second.greetingsMessage());
    }

    @Test
    void shouldFallbackToDefaultGreetingWhenEntityNotFound() {
        Long id = 999L;
		GreetingsMessageByIdRequest request = new GreetingsMessageByIdRequest(id);
        when(repository.findById(id)).thenReturn(Optional.empty());

        GreetingsMessageResponse response = useCase.process(request);

        String expected = new Hello("unknow").greetings();
        assertEquals(expected, response.greetingsMessage());
    }

    @Test
    void shouldPropagateExceptionThrownByRepository() {
        Long id = 100L;
		GreetingsMessageByIdRequest request = new GreetingsMessageByIdRequest(id);
        RuntimeException ex = new RuntimeException("lookup failed");
        when(repository.findById(id)).thenThrow(ex);

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> useCase.process(request));
        assertEquals(ex, thrown);
    }

    @Test
    void shouldThrowNullPointerExceptionWhenRequestIsNull() {
        assertThrows(NullPointerException.class, () -> useCase.process(null));
    }
}