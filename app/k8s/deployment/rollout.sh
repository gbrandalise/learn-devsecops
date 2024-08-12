#!/bin/bash

kubectl rollout undo deploy devsecops && \
watch 'kubectl get deployment,replicasets,pods'