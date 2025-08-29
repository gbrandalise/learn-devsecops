package com.neo.learn.presentation.hello;

import org.springframework.stereotype.Service;

import com.neo.learn.application.hello.GetGreetingsMessage;
import com.neo.learn.application.hello.GetGreetingsMessageById;
import com.neo.learn.application.hello.GreetingsMessageByIdRequest;
import com.neo.learn.application.hello.GreetingsMessageRequest;
import com.neo.learn.application.hello.HelloRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HelloService {

	private final HelloRepository helloRepository;

	public String greetings(String name) {
		GetGreetingsMessage useCase = new GetGreetingsMessage();
		return useCase.process(new GreetingsMessageRequest(name)).greetingsMessage();
	}

	public String greetingsById(Long id) {
		GetGreetingsMessageById useCase = new GetGreetingsMessageById(helloRepository);
		return useCase.process(new GreetingsMessageByIdRequest(id)).greetingsMessage();
	}

}
