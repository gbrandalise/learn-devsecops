package com.neo.learn.application.hello;

import com.neo.learn.application.RequestModel;

import lombok.NonNull;

public record GreetingsMessageByIdRequest(@NonNull Long id) implements RequestModel {
}
