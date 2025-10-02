#!/bin/bash

IFS= read -p "DockerHub Username: " -r DOCKER_HUB_USERNAME;
IFS= read -sp "DockerHub Password: " -r DOCKER_HUB_PASSWORD;
kubectl create secret docker-registry docker-hub-auth --docker-server=index.docker.io --docker-username=$DOCKER_HUB_USERNAME --docker-password=$DOCKER_HUB_PASSWORD