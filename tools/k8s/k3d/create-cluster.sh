#!/bin/bash

k3d cluster create --agents 3 -p "8080:30000@loadbalancer" $1 && \
kubectl cluster-info