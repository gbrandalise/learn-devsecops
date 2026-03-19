#!/bin/bash

source_dir="$(dirname "$(realpath "$0")")" && \
source ./app/k8s/env.sh && \
envsubst < "${source_dir}/configmaps.yml" | kubectl apply -f - && \
watch 'kubectl get configmap -A'