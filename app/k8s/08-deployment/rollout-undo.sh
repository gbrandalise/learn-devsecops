#!/bin/bash

kubectl rollout undo deploy devsecops -n ${NAMESPACE}-app && \
watch 'kubectl get deployment,pod -A | grep -E "'${NAMESPACE}'-db|'${NAMESPACE}'-app"'