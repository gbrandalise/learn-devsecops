package com.neo.learn.application.hello;

import com.neo.learn.domain.hello.Hello;

public class GetGreetingsMessage {

	public String process(String name) {
		var hello = new Hello();
		return hello.greetings(name);
	}

}
