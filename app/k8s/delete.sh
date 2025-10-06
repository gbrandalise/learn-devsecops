#!/bin/bash

source ./app/k8s/env.sh && \
kubectl delete namespace ${NAMESPACE}-app
kubectl delete namespace ${NAMESPACE}-db
watch 'kubectl get po,svc -A | grep -E "'${NAMESPACE}'-app|'${NAMESPACE}'-db"'