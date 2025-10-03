#!/bin/bash

export NAMESPACE="development" && \
kubectl delete namespace ${NAMESPACE} && \
watch 'kubectl get secret,svc,deploy,rs,po -n '${NAMESPACE}