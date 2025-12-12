#!/bin/bash

source ./app/k8s/env.sh && \
kubectl delete namespace --ignore-not-found ${NAMESPACE}-app
kubectl delete namespace --ignore-not-found ${NAMESPACE}-db
kubectl get po,svc -A | grep -E "${NAMESPACE}" || true