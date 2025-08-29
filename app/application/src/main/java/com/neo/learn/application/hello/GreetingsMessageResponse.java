package com.neo.learn.application.hello;

import com.neo.learn.application.ResponseModel;

import lombok.NonNull;

public record GreetingsMessageResponse(@NonNull String greetingsMessage) implements ResponseModel {
}
