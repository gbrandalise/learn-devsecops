#!/bin/bash

source ./app/k8s/env.sh && \
envsubst < ./app/k8s/12-daemonset/daemonset.yml | kubectl apply -f - && \
watch 'kubectl get nodes,daemonset,pod -A'