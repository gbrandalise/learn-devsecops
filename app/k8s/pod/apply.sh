#!/bin/bash

kubectl apply -f ./app/k8s/pod/pod.yml && \
watch 'kubectl get pods' && \
kubectl logs devsecops-latest && \
kubectl port-forward --address 0.0.0.0 pod/devsecops-pt 8080:8080