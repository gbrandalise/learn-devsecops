#!/bin/bash

export NAMESPACE="development" && \
export POSTGRES_HOST=$(echo -n "postgresql" | base64) && \
export POSTGRES_PORT=$(echo -n "5432" | base64) && \
export POSTGRES_DB_PLAIN="devsecops" && \
export POSTGRES_USER_PLAIN="devsecops" && \
export POSTGRES_PASSWORD_PLAIN="devsecops" && \
export POSTGRES_DB=$(echo -n ${POSTGRES_DB_PLAIN} | base64) && \
export POSTGRES_USER=$(echo -n ${POSTGRES_USER_PLAIN} | base64) && \
export POSTGRES_PASSWORD=$(echo -n ${POSTGRES_PASSWORD_PLAIN} | base64) && \
export GREETINGS_MESSAGE=$(echo -n "Hello %s" | base64)