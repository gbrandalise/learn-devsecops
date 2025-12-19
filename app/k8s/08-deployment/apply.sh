#!/bin/bash

source ./app/k8s/env.sh && \
envsubst < ./app/k8s/08-deployment/deployments.yml | kubectl apply -f - && \
watch 'kubectl get deployment,pod -A'