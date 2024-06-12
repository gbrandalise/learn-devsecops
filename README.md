# learn-devsecops
Repositório para aprendizagem de várias ferramentas DevSecOps, bem como implementação de ideias de ferramentas usando Java


## Dcokerfile multi stage build
```sh
docker build --target=application .
```

## Docker compose multi stage build
```sh
BUILD_TARGET=application docker compose build
```