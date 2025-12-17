#!/bin/bash

source ./app/k8s/env.sh && \
envsubst < ./app/k8s/06-volume/01-nfs/persistentvolume.yml | kubectl apply -f - && \
envsubst < ./app/k8s/06-volume/01-nfs/persistentvolumeclaim.yml | kubectl apply -f - && \
watch 'kubectl get pv,pvc -A'