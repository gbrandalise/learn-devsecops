module com.neo.learn.presentation {

	requires lombok;

	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.core;
    requires spring.beans;
	requires spring.web;
    requires spring.context;
	requires spring.boot.actuator;

	requires com.neo.learn.infrastructure;

	opens com.neo.learn.presentation;
	opens com.neo.learn.presentation.hello;
	opens com.neo.learn.presentation.probe;
	opens com.neo.learn.presentation.stress;
	opens com.neo.learn.presentation.stress.cpu;

	exports com.neo.learn.presentation;

}