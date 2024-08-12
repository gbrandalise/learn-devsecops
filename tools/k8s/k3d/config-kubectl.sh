#!/bin/bash

k3d kubeconfig merge --kubeconfig-merge-default && \
k3d cluster stop && \
k3d cluster start && \
kubectl cluster-info