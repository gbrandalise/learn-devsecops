#!/bin/bash

source ./app/k8s/env.sh && \
envsubst < ./app/k8s/01-namespace/namespaces.yml | kubectl apply -f - && \
watch 'kubectl get namespaces | grep -E "'${NAMESPACE}'-db|'${NAMESPACE}'-app"'
