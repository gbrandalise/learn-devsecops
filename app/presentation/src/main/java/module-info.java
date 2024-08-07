module com.neo.learn.presentation {
    requires com.neo.learn.application;

	requires spring.boot;
	requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.beans;
	requires spring.web;

	exports com.neo.learn.presentation.hello;

	opens com.neo.learn.presentation to spring.core;
}