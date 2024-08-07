FROM maven:3-eclipse-temurin-21-alpine
WORKDIR /devsecops
RUN apk update && apk add git openssh-client
RUN git config --global --add safe.directory /devsecops
EXPOSE 8080
CMD ["tail", "-f", "/dev/null"]