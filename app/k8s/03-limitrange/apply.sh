#!/bin/bash

source ./app/k8s/env.sh && \
envsubst < ./app/k8s/03-limitrange/limitrange.yml | kubectl apply -f - && \
watch 'kubectl get limitrange | grep -E "'${NAMESPACE}'-db|'${NAMESPACE}'-app"'
