#!/bin/bash

source ./app/k8s/env.sh && \
for f in $(find ./app/k8s/ -name "*.yml"); do
	envsubst < $f | kubectl apply -f -
done
kubectl get svc,po -A | grep -E "${NAMESPACE}"
