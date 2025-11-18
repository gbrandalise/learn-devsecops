# syntax=docker/dockerfile:1.7-labs
FROM maven:3-eclipse-temurin-21-alpine as dependency
RUN addgroup --system devsecops
RUN adduser --system devsecops --ingroup devsecops
WORKDIR /app
RUN chown -R devsecops:devsecops /app
USER devsecops
# dockerfile-utils: ignore
COPY --chown=devsecops:devsecops --parents pom.xml **/pom.xml ./
RUN mvn dependency:go-offline

FROM dependency as compile
# dockerfile-utils: ignore
COPY --chown=devsecops:devsecops --parents **/src ./
RUN mvn clean compile

FROM compile as test
RUN mvn verify

FROM compile as package
RUN mvn install -DskipTests -Dmaven.test.skip=true

FROM eclipse-temurin:21-noble
RUN addgroup --system devsecops
RUN adduser --system devsecops --ingroup devsecops
WORKDIR /app
RUN chown -R devsecops:devsecops /app
USER devsecops
COPY --chown=devsecops:devsecops --from=package /app/presentation/target/*.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]