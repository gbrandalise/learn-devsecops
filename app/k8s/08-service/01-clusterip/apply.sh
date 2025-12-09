#!/bin/bash

source ./app/k8s/env.sh && \
envsubst < ./app/k8s/08-service/01-clusterip/services.yml | kubectl apply -f - && \
watch 'kubectl get service,po -A | grep -E "'${NAMESPACE}'-db|'${NAMESPACE}'-app"'