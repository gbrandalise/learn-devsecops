package com.neo.learn.domain.hello;

public class Hello {

	private static final String GREETINGS_MESSAGE = System.getenv("GREETINGS_MESSAGE");

    public String greetings(String name) {
        return GREETINGS_MESSAGE.formatted(name);
    }

}
