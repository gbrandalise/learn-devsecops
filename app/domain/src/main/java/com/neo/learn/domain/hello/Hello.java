package com.neo.learn.domain.hello;

import java.util.Optional;

public class Hello {

	private static final String DEFAULT_GRETTINGS_MESSAGE = "Hello %s\n";
	private static final String GREETINGS_MESSAGE = Optional.ofNullable(System.getenv("GREETINGS_MESSAGE")).orElse(DEFAULT_GRETTINGS_MESSAGE);

    public String greetings(String name) {
        return GREETINGS_MESSAGE.formatted(name);
    }

}
