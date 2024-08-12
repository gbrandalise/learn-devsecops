#!/bin/bash

kubectl apply -f ./app/k8s/service/clusterip/service.yml && \
sleep 10 && \
kubectl describe service devsecops && \
kubectl run prompt -it --rm \
	--image ubuntu -- /bin/bash -c 'apt-get update && apt-get install curl --no-install-recommends -y && curl http://devsecops:8080/grettings/test'