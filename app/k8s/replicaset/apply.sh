#!/bin/bash

kubectl apply -f ./app/k8s/replicaset/replicaset.yml && \
kubectl describe replicaset devsecops && \
watch 'kubectl get replicasets,pods'