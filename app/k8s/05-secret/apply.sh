#!/bin/bash

source ./app/k8s/env.sh && \
./app/k8s/05-secret/generic.sh && \
./app/k8s/05-secret/docker-registry.sh && \
envsubst < ./app/k8s/05-secret/secrets.yml | kubectl apply -f - && \
watch 'kubectl get secret -A | grep -E "'${NAMESPACE}'-db|'${NAMESPACE}'-app"'