module com.neo.learn.application {

	requires lombok;

    requires transitive com.neo.learn.domain;

	exports com.neo.learn.application.hello;
}