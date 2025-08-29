package com.neo.learn.presentation.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HelloController {

	private final HelloService helloService;

	@GetMapping("greetings/{name}")
	public String greetings(@PathVariable String name) {
		return helloService.greetings(name);
	}

	@GetMapping("greetings/by-id/{id}")
	public String greetingsById(@PathVariable Long id) {
		return helloService.greetingsById(id);
	}

}
