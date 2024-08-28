#!/bin/bash

kind create cluster --config ./tools/k8s/kind/config.yml && \
kubectl cluster-info