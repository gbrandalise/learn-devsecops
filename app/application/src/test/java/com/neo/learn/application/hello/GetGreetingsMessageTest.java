package com.neo.learn.application.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.neo.learn.domain.hello.Hello;

class GetGreetingsMessageTest {

    @Test
    void shouldReturnResponseWithGreetingFromDomainForValidName() {
        GetGreetingsMessage useCase = new GetGreetingsMessage();
        String name = "Alice";
        GreetingsMessageRequest request = new GreetingsMessageRequest(name);

        GreetingsMessageResponse response = useCase.process(request);

        String expected = Hello.greetings(name);
        assertEquals(expected, response.greetingsMessage());
    }

    @Test
    void shouldBeIdempotentForSameInput() {
        GetGreetingsMessage useCase = new GetGreetingsMessage();
        String name = "Bob";
        GreetingsMessageRequest request = new GreetingsMessageRequest(name);

        GreetingsMessageResponse first = useCase.process(request);
        GreetingsMessageResponse second = useCase.process(request);

        assertEquals(first.greetingsMessage(), second.greetingsMessage());
    }

    @Test
    void shouldThrowWhenRequestIsNull() {
        GetGreetingsMessage useCase = new GetGreetingsMessage();
        assertThrows(NullPointerException.class, () -> useCase.process(null));
    }

    @Test
    void shouldHandleEmptyNameByDelegatingWithoutModification() {
        GetGreetingsMessage useCase = new GetGreetingsMessage();
        String name = "";
        GreetingsMessageRequest request = new GreetingsMessageRequest(name);

        GreetingsMessageResponse response = useCase.process(request);

        String expected = Hello.greetings(name);
        assertEquals(expected, response.greetingsMessage());
    }
}