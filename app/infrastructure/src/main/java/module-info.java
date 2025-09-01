module com.neo.learn.infrastructure {

	requires java.compiler;

	requires jakarta.persistence;

	requires spring.boot;
	requires spring.boot.autoconfigure;
    requires spring.context;
	requires spring.core;
    requires spring.beans;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.tx;
	requires spring.aop;

	requires org.hibernate.orm.core;

	requires lombok;

	requires org.mapstruct;

	requires com.neo.learn.domain;
    requires com.neo.learn.application;

	opens com.neo.learn.infrastructure to spring.core, spring.context, spring.beans;
	opens com.neo.learn.infrastructure.jpa.hello;
}