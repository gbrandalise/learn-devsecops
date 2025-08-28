#!/bin/bash

#kubectl create secret generic devsecops-secret --from-literal=GREETING_MESSAGE="Hello %s\n"
export GREETINGS_MESSAGE=$(echo -n "Hello %s\n" | base64) && \
envsubst < ./app/k8s/secret/secret.yml | kubectl apply -f - && \
kubectl describe secret devsecops-secret