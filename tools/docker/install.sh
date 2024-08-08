#!/bin/bash

apt-get remove \
	docker.io \
	docker-doc \
	docker-compose \
	docker-compose-v2 \
	podman-docker \
	containerd \
	runc && \
curl -fsSL https://get.docker.com -o get-docker.sh && \
sh ./get-docker.sh --dry-run && \
systemctl enable docker.service && \
systemctl enable containerd.service && \
docker version