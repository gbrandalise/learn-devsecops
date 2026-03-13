#!/bin/bash

source ./app/k8s/env.sh && \
envsubst < ./app/k8s/13-job/job.yml | kubectl apply -f - && \
watch 'kubectl get job -A'