#!/bin/bash

WORKDIR="$(pwd)"
RUNNER_DIR="${WORKDIR}/tools/github/actions-runner"

if [[ -d "${RUNNER_DIR}" ]]; then
	echo "Enter the runner directory"
	cd "${RUNNER_DIR}" && \
	echo "Copying .sh files to the runner directory"
	cp ../*.sh* ./ && \
	echo "Running the runner!"
	nohup ./run.sh > nohup.out 2>&1 &
	echo "Return to the original directory"
	cd ${WORKDIR}
fi