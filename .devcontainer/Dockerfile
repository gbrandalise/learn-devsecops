FROM maven:3-eclipse-temurin-21
WORKDIR /devsecops

# Install Git
RUN apt-get update && \
	apt-get install git openssh-client --no-install-recommends -y
RUN git config --global --add safe.directory /devsecops

# Install Kubectl
RUN curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl" && \
	curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl.sha256" && \
	echo "$(cat kubectl.sha256) kubectl" | sha256sum --check
RUN install -m 0755 kubectl /usr/local/bin/kubectl
RUN kubectl version --client

EXPOSE 8080
CMD ["tail", "-f", "/dev/null"]