#!/bin/bash

kubectl apply -f ./app/k8s/pod/pod.yml && \
sleep 60 && \
kubectl describe pod devsecops && \
kubectl get pods && \
kubectl port-forward --address 0.0.0.0 pod/devsecops 8080:8080