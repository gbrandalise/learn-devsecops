#!/bin/bash

export POSTGRES_USER=$(echo -n "devsecops" | base64) && \
export POSTGRES_PASSWORD=$(echo -n "devsecops" | base64) && \
export POSTGRES_DB=$(echo -n "devsecops" | base64) && \
envsubst < ./app/k8s/all.yml | kubectl apply -f - && \
watch 'kubectl get secret,svc,deploy,rs,po'