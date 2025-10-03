#!/bin/bash

export NAMESPACE="development" && \
kubectl delete namespace ${NAMESPACE}-app && \
kubectl delete namespace ${NAMESPACE}-db && \
watch 'kubectl get all -n '${NAMESPACE}'-db && kubectl get all -n '${NAMESPACE}'-app'