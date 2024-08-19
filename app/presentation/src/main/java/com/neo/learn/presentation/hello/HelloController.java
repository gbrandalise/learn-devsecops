package com.neo.learn.presentation.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.neo.learn.application.hello.GetGreetingsMessage;

@RestController
public class HelloController {

	@GetMapping("greetings/{name}")
	public String greetings(@PathVariable String name) {
		GetGreetingsMessage getGreetingsMessage = new GetGreetingsMessage();
		return getGreetingsMessage.process(name);
	}

}
