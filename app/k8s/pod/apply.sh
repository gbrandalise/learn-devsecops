#!/bin/bash

kubectl apply -f ./app/k8s/pod/pod.yml && \
kubectl get pods && \
kubectl describe pod devsecops