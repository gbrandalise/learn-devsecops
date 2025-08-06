#!/bin/bash

kind create cluster --retain --config ./tools/k8s/kind/config.yml && \
kubectl cluster-info