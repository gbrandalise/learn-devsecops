module com.neo.learn.infrastructure {

	requires java.compiler;

	requires lombok;

	requires transitive org.mapstruct;

	requires transitive jakarta.persistence;

	requires spring.boot;
	requires spring.boot.autoconfigure;
    requires transitive spring.context;
    requires transitive spring.beans;
	requires transitive spring.data.jpa;
	requires transitive spring.data.commons;

	requires transitive com.neo.learn.domain;
    requires transitive com.neo.learn.application;

	opens com.neo.learn.infrastructure to spring.beans;
	opens com.neo.learn.infrastructure.hello to spring.beans;
	opens com.neo.learn.infrastructure.hello.jpa to org.mapstruct, spring.beans;

}