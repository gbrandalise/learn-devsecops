#!/bin/bash

echo "Load env vars"
source /root/.env && \
echo "Validate that the GH_PAT environment variable is set"
if [[ -z "${GH_PAT}" ]]; then
  echo "[erro] Defina variavel de ambiente GH_PAT (PAT com permissões: repo/admin)." >&2;
  exit 1
fi

WORKDIR="$(pwd)"
RUNNER_DIR="${WORKDIR}/tools/github/actions-runner"
API_URL="https://api.github.com/repos/gbrandalise/learn-devsecops"
RUNNER_URL="https://github.com/gbrandalise/learn-devsecops"

echo "Delete the folder if exists"
rm -rf "${RUNNER_DIR}"
echo "Create the folder"
mkdir "${RUNNER_DIR}" && \
echo "Enter the directory where you want to create the runner"
cd "${RUNNER_DIR}" && \
echo "Download the latest runner package"
curl -o actions-runner-linux-x64-2.329.0.tar.gz -L https://github.com/actions/runner/releases/download/v2.329.0/actions-runner-linux-x64-2.329.0.tar.gz && \
echo "Extract the installer"
tar xzfv ./actions-runner-linux-x64-2.329.0.tar.gz && \
echo "Copy .sh files to the runner directory"
cp ../*.sh* . && \
echo "Get registration runner token from GitHub API"
REGISTRATION_TOKEN=$(curl -s -X POST \
	-H "Accept: application/vnd.github+json" \
	-H "Authorization: Bearer ${GH_PAT}" \
	-H "X-GitHub-Api-Version: 2022-11-28" \
	"${API_URL}/actions/runners/registration-token" | jq -r ".token") && \
echo "Remove the existing runner if it exists"
./config.sh remove --token "${REGISTRATION_TOKEN}"
echo "Reenter the directory"
cd "${RUNNER_DIR}" && \
echo "Create the runner and start the configuration experience"
./config.sh --url "${RUNNER_URL}" \
	--token ${REGISTRATION_TOKEN} \
	--name "learn-devsecops-runner" \
	--ephemeral \
	--work "${WORKDIR}" \
	--replace \
	--unattended && \
echo "Last step, run it!"
nohup ./run.sh > nohup.out 2>&1 &
echo "Return to the original directory"
cd ${WORKDIR}