#!/bin/bash

source ./app/k8s/env.sh && \
for f in $(find ./app/k8s/ -name "*.yml"); do
	envsubst < $f | kubectl apply -f - && \
	./app/k8s/03-secret/docker-registry.sh
done
watch 'kubectl get svc,po -A | grep -E "'${NAMESPACE}'-db|'${NAMESPACE}'-app"'
