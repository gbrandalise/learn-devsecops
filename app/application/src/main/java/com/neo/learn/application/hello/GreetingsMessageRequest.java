package com.neo.learn.application.hello;

import com.neo.learn.application.RequestModel;

import lombok.NonNull;

public record GreetingsMessageRequest(@NonNull String name) implements RequestModel {
}
