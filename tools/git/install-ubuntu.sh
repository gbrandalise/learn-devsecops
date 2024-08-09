#!/bin/bash

apt-get install git openssh-client --no-install-recommends -y && \
git config --global --add safe.directory $1