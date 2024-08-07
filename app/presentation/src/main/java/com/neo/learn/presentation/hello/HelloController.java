package com.neo.learn.presentation.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.neo.learn.application.hello.GetGrettingsMessage;

@RestController
public class HelloController {

	@GetMapping("grettings/{name}")
	public String grettings(@PathVariable String name) {
		GetGrettingsMessage getGrettingsMessage = new GetGrettingsMessage();
		return getGrettingsMessage.process(name);
	}

}
