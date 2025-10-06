#!/bin/bash

if ! kubectl get secret devsecops-secret -n ${NAMESPACE}-app &> /dev/null; then
	kubectl create secret generic devsecops-secret --from-literal=GREETING_MESSAGE="Hello %s" -n ${NAMESPACE}-app
fi