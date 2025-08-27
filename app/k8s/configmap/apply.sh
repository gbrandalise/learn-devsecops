#!/bin/bash

kubectl apply -f ./app/k8s/configmap/configmap.yml && \
kubectl describe configmap devsecops-configmap