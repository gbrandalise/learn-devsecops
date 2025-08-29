module com.neo.learn.presentation {

	requires spring.boot;
	requires spring.boot.autoconfigure;
    requires spring.context;
	requires spring.core;
    requires spring.beans;
	requires spring.web;

	requires java.instrument;

	requires lombok;

    requires com.neo.learn.domain;
    requires com.neo.learn.application;
	requires com.neo.learn.infrastructure;

	opens com.neo.learn.presentation to spring.core;
	opens com.neo.learn.presentation.hello to spring.core;

}