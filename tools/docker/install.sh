#!/bin/bash

sudo apt-get remove \
	docker.io \
	docker-doc \
	docker-compose \
	docker-compose-v2 \
	podman-docker \
	containerd \
	runc && \
curl -fsSL https://get.docker.com -o get-docker.sh && \
sudo sh ./get-docker.sh --dry-run && \
sudo service docker restart && \
sudo groupadd docker && \
sudo usermod -aG docker $USER && \
sudo newgrp docker && \
docker version