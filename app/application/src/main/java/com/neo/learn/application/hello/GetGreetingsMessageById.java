package com.neo.learn.application.hello;

import com.neo.learn.application.UseCase;
import com.neo.learn.domain.hello.Hello;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetGreetingsMessageById implements UseCase<GreetingsMessageByIdRequest, GreetingsMessageResponse> {

	private final HelloRepository repository;

	public GreetingsMessageResponse process(GreetingsMessageByIdRequest request) {
		Hello entity = repository.findById(request.id()).orElse(new Hello("unknow"));
		return new GreetingsMessageResponse(entity.greetings());
	}

}
