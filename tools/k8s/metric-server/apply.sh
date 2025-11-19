#!/bin/bash

kubectl apply -f ./tools/k8s/metric-server/components.yaml
watch 'kubectl get pod -n kube-system'