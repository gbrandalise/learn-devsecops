module com.neo.learn.presentation {

	requires lombok;

	requires spring.boot;
	requires spring.boot.autoconfigure;
    requires spring.beans;
	requires spring.web;
    requires spring.context;

	requires com.neo.learn.infrastructure;

	opens com.neo.learn.presentation;
	opens com.neo.learn.presentation.hello;

	exports com.neo.learn.presentation;

}