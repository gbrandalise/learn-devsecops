#!/bin/bash

source ./app/k8s/env.sh && \
envsubst < ./app/k8s/05-pod/pods.yml | kubectl apply -f - && \
watch 'kubectl get pod -A | grep -E "'${NAMESPACE}'-db|'${NAMESPACE}'-app"'