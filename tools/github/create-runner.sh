#!/bin/bash

WORKDIR="$(pwd)"
RUNNER_DIR="${WORKDIR}/tools/github/actions-runner"
API_URL="https://api.github.com/repos/gbrandalise/learn-devsecops"
RUNNER_URL="https://github.com/gbrandalise/learn-devsecops"

validateEnvVars() {
	echo "Load env vars"
	source /root/.env && \
	echo "Validate that the GH_PAT environment variable is set"
	if [[ -z "${GH_PAT}" ]]; then
		echo "[erro] Defina variavel de ambiente GH_PAT (PAT com permissões: repo/admin)." >&2;
		exit 1
	fi
}

startRunner() {
	createRunner

	echo "Running the runner!"
	cd "${RUNNER_DIR}" && \
	nohup ./run.sh > nohup.out 2>&1 &
}

downloadRunner() {
	echo "Delete the runner directory"
	rm -rf "${RUNNER_DIR}"
	echo "Create the runner directory"
	mkdir "${RUNNER_DIR}" && \
	echo "Enter the runner directory"
	cd "${RUNNER_DIR}" && \
	echo "Download the latest runner package"
	curl -o actions-runner-linux-x64-2.329.0.tar.gz -L https://github.com/actions/runner/releases/download/v2.329.0/actions-runner-linux-x64-2.329.0.tar.gz && \
	echo "Extract the installer"
	tar xzf ./actions-runner-linux-x64-2.329.0.tar.gz && \
	echo "Copying .sh files to the runner directory"
	cp ../*.sh* ./

	createRunner
}

createRunner() {
	validateEnvVars

	echo "Get registration runner token from GitHub API"
	REGISTRATION_TOKEN=$(curl -s -X POST \
		-H "Accept: application/vnd.github+json" \
		-H "Authorization: Bearer ${GH_PAT}" \
		-H "X-GitHub-Api-Version: 2022-11-28" \
		"${API_URL}/actions/runners/registration-token" | jq -r ".token") && \
	echo "Create the runner"
	cd "${RUNNER_DIR}" && \
	./config.sh --url "${RUNNER_URL}" \
		--token ${REGISTRATION_TOKEN} \
		--name "learn-devsecops-runner" \
		--labels "devcontainer" \
		--work "${WORKDIR}" \
		--replace \
		--unattended
}

if [[ -d "${RUNNER_DIR}" ]]; then
	startRunner
else
	downloadRunner
fi

echo "Return to the original directory"
cd ${WORKDIR}