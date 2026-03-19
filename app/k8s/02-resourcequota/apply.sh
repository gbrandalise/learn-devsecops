#!/bin/bash

source_dir="$(dirname "$(realpath "$0")")" && \
source ./app/k8s/env.sh && \
envsubst < "${source_dir}/resourcequota.yml" | kubectl apply -f - && \
watch 'kubectl get resourcequota -A'
