#!/bin/bash

kind delete cluster --name meucluster
kind create cluster --name meucluster --retain --config=./tools/k8s/kind/config-meucluster.yml && \
kind export kubeconfig --name meucluster && \
kubectl cluster-info --context kind-meucluster