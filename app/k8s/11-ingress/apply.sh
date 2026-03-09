#!/bin/bash

source ./app/k8s/env.sh && \
envsubst < ./app/k8s/11-ingress/ingress.yml | kubectl apply -f - && \
watch 'kubectl get ingress -A'