#!/bin/bash

source ./app/k8s/env.sh && \
envsubst < ./app/k8s/10-service/04-nodeport/services.yml | kubectl apply -f - && \
watch 'kubectl get service,po -A'