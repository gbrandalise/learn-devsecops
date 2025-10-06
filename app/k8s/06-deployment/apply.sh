#!/bin/bash

source ./app/k8s/env.sh && \
envsubst < ./app/k8s/06-deployment/deployments.yml | kubectl apply -f - && \
watch 'kubectl get deployment,pod -A | grep -E "'${NAMESPACE}'-app|'${NAMESPACE}'-db"'