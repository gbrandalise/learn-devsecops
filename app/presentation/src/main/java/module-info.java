module com.neo.learn.presentation {

	requires java.instrument;

	requires spring.boot;
	requires spring.boot.autoconfigure;
    requires spring.context;
	requires spring.core;
    requires spring.beans;
	requires spring.web;

	requires lombok;

    requires com.neo.learn.domain;
    requires com.neo.learn.application;
	requires com.neo.learn.infrastructure;

	exports com.neo.learn.presentation;

	opens com.neo.learn.presentation to spring.core;
	opens com.neo.learn.presentation.hello to spring.core, spring.beans, spring.web;

}