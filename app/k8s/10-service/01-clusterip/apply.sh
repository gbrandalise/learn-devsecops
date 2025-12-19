#!/bin/bash

source ./app/k8s/env.sh && \
envsubst < ./app/k8s/10-service/01-clusterip/services.yml | kubectl apply -f - && \
watch 'kubectl get service,po -A'