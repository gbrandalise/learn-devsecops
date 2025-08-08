#!/bin/bash

kind create cluster --retain --config=./tools/k8s/kind/config.yml -v=6 && \
kind export kubeconfig && \
kubectl cluster-info