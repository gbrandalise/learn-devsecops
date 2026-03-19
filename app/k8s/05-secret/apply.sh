#!/bin/bash

source_dir="$(dirname "$(realpath "$0")")" && \
source ./app/k8s/env.sh && \
./app/k8s/05-secret/generic.sh && \
./app/k8s/05-secret/docker-registry.sh && \
envsubst < "${source_dir}/secrets.yml" | kubectl apply -f - && \
watch 'kubectl get secret -A'