#!/bin/bash

source ./app/k8s/env.sh && \
envsubst < ./app/k8s/07-service/02-external/services.yml | kubectl apply -f - && \
watch 'kubectl get service,po -A | grep -E "'${NAMESPACE}'-app|'${NAMESPACE}'-db"'