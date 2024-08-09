#!/bin/bash

kubectl apply -f ./app/k8s/replicaset/replicaset.yml && \
kubectl describe replicaset devsecops && \
kubectl get replicaset && \
watch 'kubectl get pods'