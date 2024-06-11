# syntax=docker/dockerfile:1.7-labs
FROM maven:3-eclipse-temurin-21-alpine as dependency
WORKDIR /app
# dockerfile-utils: ignore
COPY --parents pom.xml **/pom.xml ./
RUN mvn dependency:go-offline

FROM dependency as compile
# dockerfile-utils: ignore
COPY --parents **/src ./
RUN mvn clean compile

FROM compile as test
RUN mvn test

FROM compile as build
RUN mvn package

FROM openjdk:21-slim as application
WORKDIR /app
COPY --from=build /app/compiler/target/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]