#!/bin/bash

source ./app/k8s/env.sh && \
envsubst < ./app/k8s/09-service/03-loadbalancer/services.yml | kubectl apply -f - && \
watch 'kubectl get service,po -A | grep -E "'${NAMESPACE}'-db|'${NAMESPACE}'-app"'