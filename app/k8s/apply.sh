#!/bin/bash

source ./app/k8s/env.sh && \
for f in $(find ./app/k8s/ -name "*.yml"); do
	envsubst < $f | kubectl apply -f -
done
./tools/k8s/kubectx/current-namespace-development-app.sh && \
kubectl get svc,po -A | grep -E "${NAMESPACE}"
