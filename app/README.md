## Dcokerfile multi stage build
```sh
docker build --target=application .
```

## Docker compose multi stage build
```sh
BUILD_TARGET=application docker compose build
```

## Docker push image to Github Container Registry
```sh
IFS= read -p "Github Access Token: " -r GITHUB_TOKEN && echo $GITHUB_TOKEN | docker login https://ghcr.io -u gbrandalise --password-stdin 
docker image tag learn-devsecops ghcr.io/gbrandalise/learn-devsecops
docker push ghcr.io/gbrandalise/devsecops
```