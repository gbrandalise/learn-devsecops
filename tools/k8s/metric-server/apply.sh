#!/bin/bash

kubectl apply -f ./tools/k8s/metric-server/components.yaml
kubectl get pod -n kube-system
# kubectl top nodes