package com.neo.learn.domain.hello;

import java.util.Optional;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Hello {

	private static final String DEFAULT_GRETTINGS_MESSAGE = "Hello %s";
	private static final String GREETINGS_MESSAGE = Optional.ofNullable(System.getenv("GREETINGS_MESSAGE")).orElse(DEFAULT_GRETTINGS_MESSAGE);

	@Getter
	private Long id;
	@Getter
	private final String name;

	public Hello(Long id, String name) {
		this(name);
		this.id = id;
	}

    public static String greetings(String name) {
        return GREETINGS_MESSAGE.formatted(name);
    }

	public String greetings() {
		return greetings(name);
	}

}
