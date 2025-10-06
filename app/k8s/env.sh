#!/bin/bash

export NAMESPACE="development" && \
export POSTGRES_HOST=$(echo -n "postgresql" | base64) && \
export POSTGRES_PORT=$(echo -n "5432" | base64) && \
export POSTGRES_DB=$(echo -n "devsecops" | base64) && \
export POSTGRES_USER=$(echo -n "devsecops" | base64) && \
export POSTGRES_PASSWORD=$(echo -n "devsecops" | base64) && \
export GREETINGS_MESSAGE=$(echo -n "Hello %s" | base64)