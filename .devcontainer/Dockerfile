FROM docker:latest
WORKDIR /devsecops

COPY ./tools/ ./tools

RUN ./tools/java/jdk/install-alpine.sh

EXPOSE 8080
CMD while sleep 120 && ps aux | egrep 'vscode.*[b]ootstrap-fork.*extensionHost.*' > /dev/null; do :; done