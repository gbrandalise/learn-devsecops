#!/bin/bash

docker volume create vol_nfs && \
docker run -d --name nfs-server \
  --privileged \
  --restart unless-stopped \
  -e SHARED_DIRECTORY=/data \
  -v vol_nfs:/data \
  -p 2049:2049 \
  --network kind \
  itsthenetwork/nfs-server-alpine:12