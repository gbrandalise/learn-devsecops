#!/bin/bash

kubectl apply -f ./app/k8s/service/clusterip/service.yml && \
kubectl describe service devsecops && \
sleep 10 && \
kubectl run prompt -it --rm \
	--image ubuntu -- /bin/bash -c 'apt-get update && apt-get install curl --no-install-recommends -y && curl http://devsecops:30000/greetings/test'