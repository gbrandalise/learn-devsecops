#!/bin/bash

source ./app/k8s/env.sh && \
envsubst < ./app/k8s/07-pod/pods.yml | kubectl apply -f - && \
watch 'kubectl get pod -A'