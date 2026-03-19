#!/bin/bash

source_dir="$(dirname "$(realpath "$0")")" && \
source ./app/k8s/env.sh && \
envsubst < "${source_dir}/01-storageprovisioner.yml" | kubectl apply -f - && \
envsubst < "${source_dir}/02-storageclass.yml" | kubectl apply -f - && \
envsubst < "${source_dir}/03-persistencevolume.yml" | kubectl apply -f - && \
envsubst < "${source_dir}/04-persistentvolumeclaim.yml" | kubectl apply -f - && \
watch 'kubectl get storageclass,pv,pvc -A'