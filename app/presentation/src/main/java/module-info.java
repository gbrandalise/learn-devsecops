module com.neo.learn.presentation {

	requires spring.boot;
	requires spring.boot.autoconfigure;
    requires spring.context;
	requires spring.core;
    requires spring.beans;
	requires spring.web;

	requires java.instrument;

    requires com.neo.learn.application;

	exports com.neo.learn.presentation;
	exports com.neo.learn.presentation.hello;

	opens com.neo.learn.presentation to spring.core;

}