#!/bin/bash

./.devcontainer/install-dependencies.sh && \
./tools/git/config.sh && \
./tools/github/create-runner.sh && \
./tools/k8s/kind/create-cluster.sh && \
./tools/k8s/kind/config-kubectl.sh && \
./tools/docker/create-nfs-server.sh