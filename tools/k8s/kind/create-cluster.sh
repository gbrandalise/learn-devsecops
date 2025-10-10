#!/bin/bash

kind create cluster --retain --config=./tools/k8s/kind/config-kind.yml && \
kind export kubeconfig && \
kubectl cluster-info --context kind-kind