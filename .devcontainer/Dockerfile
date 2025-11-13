# Slim, explicit base; alternative: mcr.microsoft.com/devcontainers/java:1-21-bookworm
FROM eclipse-temurin:21-jdk AS base
# Albian-based image

FROM base as development
RUN echo 'setting up dev container'

# Build Variables
ARG USERNAME=vscode

# Basic Dependencies: standard CLIs;
#   ca certs & gnupg for terminal auth
RUN apt-get update && DEBIAN_FRONTEND=noninteractive apt-get install -y \
  git curl unzip jq bash-completion ca-certificates gnupg \
  && rm -rf /var/lib/apt/lists/*

# install sudo without password config
RUN apt-get update && apt-get install -y sudo \
 && echo "${USERNAME} ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers

# Create non-root user for Dev Containers CLI UX
RUN groupadd ${USERNAME} \
 && useradd -m -s /bin/bash -g ${USERNAME} ${USERNAME}

# Install DataDog CI
# TODO: install npm
# RUN npm i -g @datadog/datadog-ci \
#   && npm cache clean --force

# Final defaults
USER ${USERNAME}
WORKDIR /workspaces