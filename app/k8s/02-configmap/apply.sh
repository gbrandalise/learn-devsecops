#!/bin/bash

source ./app/k8s/env.sh && \
envsubst < ./app/k8s/02-configmap/configmaps.yml | kubectl apply -f - && \
watch 'kubectl get configmap -A | grep -E "'${NAMESPACE}'-app|'${NAMESPACE}'-db"'