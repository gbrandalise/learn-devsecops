#!/bin/bash

source ./app/k8s/env.sh && \
envsubst < ./app/k8s/03-configmap/configmaps.yml | kubectl apply -f - && \
watch 'kubectl get configmap -A | grep -E "'${NAMESPACE}'-db|'${NAMESPACE}'-app"'