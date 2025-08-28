package com.neo.learn.domain.hello;

import java.util.Optional;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Hello {

	private static final String DEFAULT_GRETTINGS_MESSAGE = "Hello %s";
	private static final String GREETINGS_MESSAGE = Optional.ofNullable(System.getenv("GREETINGS_MESSAGE")).orElse(DEFAULT_GRETTINGS_MESSAGE);

	private HelloRepository repository;

	@Getter
	private final Long id;
	@Getter
	private final String name;

	public Hello(HelloRepository repository) {
		this(null, null);
		this.repository = repository;
	}

    public String greetings(String name) {
        return GREETINGS_MESSAGE.formatted(name);
    }

	public String greetings() {
		return greetings(name);
	}

    public String greetingsById(Long id) {
		Optional<Hello> hello = repository.findById(id);
		return hello.map(Hello::greetings).orElse(greetings("null"));
    }

}
