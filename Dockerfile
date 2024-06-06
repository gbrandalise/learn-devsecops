# syntax=docker/dockerfile:1.7-labs
FROM maven:3-eclipse-temurin-21-alpine as dependency
WORKDIR /app
# dockerfile-utils: ignore
COPY --parents pom.xml **/pom.xml ./
RUN mvn dependency:go-offline