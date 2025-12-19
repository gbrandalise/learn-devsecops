#!/bin/bash

source ./app/k8s/env.sh && \
envsubst < ./app/k8s/02-resourcequota/resourcequota.yml | kubectl apply -f - && \
watch 'kubectl get resourcequota -A'
