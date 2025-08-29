module com.neo.learn.infrastructure {

	requires spring.boot;
	requires spring.boot.autoconfigure;
    requires spring.context;
	requires spring.core;
    requires spring.beans;
	requires spring.data.jpa;

	requires jakarta.persistence;

	requires lombok;

	requires org.mapstruct;

	requires com.neo.learn.domain;
    requires com.neo.learn.application;

	opens com.neo.learn.infrastructure.jpa.hello to spring.core, org.mapstruct;
}