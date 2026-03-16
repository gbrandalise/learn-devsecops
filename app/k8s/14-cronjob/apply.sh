#!/bin/bash

source ./app/k8s/env.sh && \
envsubst < ./app/k8s/14-cronjob/cronjob.yml | kubectl apply -f - && \
watch 'kubectl get cronjob,job,pod -A'