#!/bin/bash

curl -Lo ./kind https://kind.sigs.k8s.io/dl/v0.29.0/kind-linux-amd64 && \
chmod +x ./kind && \
mv ./kind /usr/local/bin/kind && \
kind version
