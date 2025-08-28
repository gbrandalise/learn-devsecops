#!/bin/bash

#kubectl create secret generic devsecops-secret --from-literal=GREETING_MESSAGE="Hello %s"
export GREETINGS_MESSAGE=$(echo -n "Hello %s" | base64) && \
envsubst < ./app/k8s/secret/secret.yml | kubectl apply -f - && \
kubectl describe secret devsecops-secret