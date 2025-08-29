package com.neo.learn.application;

public interface UseCase<T extends RequestModel, R extends ResponseModel> {

	R process(T request);

}
