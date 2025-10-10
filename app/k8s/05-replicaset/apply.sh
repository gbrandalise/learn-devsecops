#!/bin/bash

source ./app/k8s/env.sh && \
envsubst < ./app/k8s/05-replicaset/replicasets.yml | kubectl apply -f - && \
watch 'kubectl get replicaset,pod -A | grep -E "'${NAMESPACE}'-db|'${NAMESPACE}'-app"'