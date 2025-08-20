#!/bin/bash

kubectl apply -f ./app/k8s/pod/pod.yml && \
watch 'kubectl get pods' && \
kubectl port-forward --address 0.0.0.0 pod/devsecops-latest 8080:8080