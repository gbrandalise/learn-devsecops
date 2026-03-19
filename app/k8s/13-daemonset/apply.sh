#!/bin/bash

source_dir="$(dirname "$(realpath "$0")")" && \
source ./app/k8s/env.sh && \
envsubst < "${source_dir}/daemonset.yml" | kubectl apply -f - && \
watch 'kubectl get nodes,daemonset,pod -A'