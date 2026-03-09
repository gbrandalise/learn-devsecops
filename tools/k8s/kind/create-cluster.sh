#!/bin/bash

kind delete cluster --name kind
kind create cluster --retain --config=./tools/k8s/kind/config-kind.yml && \
./tools/k8s/kind/config-kubectl.sh && \
./tools/k8s/kubectx/install-ubuntu.sh && \
./tools/k8s/kubectx/current-context-kind.sh