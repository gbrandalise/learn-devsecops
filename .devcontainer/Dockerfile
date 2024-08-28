FROM maven:3-eclipse-temurin-21
WORKDIR /devsecops

COPY ./tools/ ./tools
RUN apt-get update && apt-get install curl wget --no-install-recommends -y && \
	./tools/git/install-ubuntu.sh /devsecops && \
	./tools/k8s/kubectl/install-ubuntu.sh && \
	./tools/k8s/k3d/install-ubuntu.sh && \
	./tools/k8s/kind/install-ubuntu.sh

EXPOSE 8080
CMD while sleep 120 && ps aux | egrep 'vscode.*[b]ootstrap-fork.*extensionHost.*' > /dev/null; do :; done