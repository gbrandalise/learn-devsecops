#!/bin/bash

kubectl apply -f ./app/k8s/pod/pod.yml && \
sleep 30 && \
kubectl describe pod devsecops && \
kubectl get pods && \
kubectl port-forward pod/devsecops 8080:8080