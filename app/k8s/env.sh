#!/bin/bash

export NAMESPACE="development" && \
export POSTGRES_HOST_PLAIN="postgresql" && \
export POSTGRES_PORT_PLAIN="5432" && \
export POSTGRES_DB_PLAIN="devsecops" && \
export POSTGRES_USER_PLAIN="devsecops" && \
export POSTGRES_PASSWORD_PLAIN="devsecops" && \
export GREETINGS_MESSAGE_PLAIN="Hello %s" && \
export POSTGRES_HOST=$(echo -n ${POSTGRES_HOST_PLAIN} | base64) && \
export POSTGRES_PORT=$(echo -n ${POSTGRES_PORT_PLAIN} | base64) && \
export POSTGRES_DB=$(echo -n ${POSTGRES_DB_PLAIN} | base64) && \
export POSTGRES_USER=$(echo -n ${POSTGRES_USER_PLAIN} | base64) && \
export POSTGRES_PASSWORD=$(echo -n ${POSTGRES_PASSWORD_PLAIN} | base64) && \
export GREETINGS_MESSAGE=$(echo -n ${GREETINGS_MESSAGE_PLAIN} | base64)