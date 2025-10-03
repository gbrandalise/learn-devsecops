#!/bin/bash

kubectl apply -f ./app/k8s/namespace/namespace.yml && \
watch 'kubectl get namespace'