#!/bin/bash

kubectl apply -f ./app/k8s/deployment/deployment.yml && \
kubectl describe deployment devsecops && \
watch 'kubectl get deployment,replicasets,pods'