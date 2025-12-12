#!/bin/bash

WORKDIR="$(pwd)"
RUNNER_DIR="${WORKDIR}/tools/github/actions-runner"

if [[ -d "${RUNNER_DIR}" ]]; then
	echo "Running the runner!"
	nohup ./run.sh > nohup.out 2>&1 &
	echo "Return to the original directory"
	cd ${WORKDIR}
fi