#!/bin/bash

apt-get update && \
apt-get install git openssh-client && \
git config --global --add safe.directory $1