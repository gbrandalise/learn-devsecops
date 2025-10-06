#!/bin/bash

source ./app/k8s/env.sh && \
./app/k8s/03-secret/generic.sh && \
./app/k8s/03-secret/docker-registry.sh && \
envsubst < ./app/k8s/03-secret/secrets.yml | kubectl apply -f - && \
watch 'kubectl get secret -A | grep -E "'${NAMESPACE}'-app|'${NAMESPACE}'-db"'