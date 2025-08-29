package com.neo.learn.application.hello;

import com.neo.learn.application.UseCase;
import com.neo.learn.domain.hello.Hello;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class GetGreetingsMessage implements UseCase<GreetingsMessageRequest, GreetingsMessageResponse> {

	public GreetingsMessageResponse process(@NonNull GreetingsMessageRequest request) {
		return new GreetingsMessageResponse(Hello.greetings(request.name()));
	}

}
