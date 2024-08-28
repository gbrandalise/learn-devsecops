#!/bin/bash

kubectl apply -f ./app/k8s/service/nodeport/service.yml && \
kubectl describe service devsecops