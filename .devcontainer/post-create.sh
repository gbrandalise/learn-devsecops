#!/bin/bash

./.devcontainer/install-dependencies.sh && \
./.devcontainer/load-env.sh && \
./tools/git/config.sh && \
./tools/github/create-runner.sh && \
./tools/k8s/kind/create-cluster.sh