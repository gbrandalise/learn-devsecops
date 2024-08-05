FROM maven:3-eclipse-temurin-21-alpine
WORKDIR /app
RUN apk update && apk add git openssh-client
EXPOSE 8080
CMD ["tail", "-f", "/dev/null"]