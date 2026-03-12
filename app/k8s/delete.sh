#!/bin/bash

source ./app/k8s/env.sh && \
kubectl delete --force namespace --ignore-not-found ${NAMESPACE}-app && \
kubectl delete --force namespace --ignore-not-found ${NAMESPACE}-db && \
kubectl delete --force pv devsecops-db-nfs
kubectl get po,svc -A | grep -E "${NAMESPACE}" || true