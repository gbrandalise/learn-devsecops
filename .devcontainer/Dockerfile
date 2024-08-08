FROM maven:3-eclipse-temurin-21
WORKDIR /devsecops

# Install Git
RUN apt-get update && \
	apt-get install git openssh-client --no-install-recommends -y
RUN git config --global --add safe.directory /devsecops

EXPOSE 8080
CMD while sleep 120 && ps aux | egrep 'vscode.*[b]ootstrap-fork.*extensionHost.*' > /dev/null; do :; done