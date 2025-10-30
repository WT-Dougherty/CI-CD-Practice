# Slim, explicit base; alternative: mcr.microsoft.com/devcontainers/java:1-21-bookworm
FROM eclipse-temurin:21-jdk AS base

FROM base as development
RUN echo 'setting up dev container'

# Build Variables
ARG USERNAME=vscode

# Basic Dependencies: apt-get for Debian Distro & standard CLIs
#   ca certs & gnupg for terminal auth
RUN apt-get update && DEBIAN_FRONTEND=noninteractive apt-get install -y \
  git curl unzip jq bash-completion ca-certificates gnupg \
  && rm -rf /var/lib/apt/lists/*

# Create non-root user for Dev Containers CLI UX
RUN groupadd ${USERNAME} \
 && useradd -m -s /bin/bash -g ${USERNAME} ${USERNAME}

# Install Node.js & npm for scripts and environment package management
RUN curl -fsSL https://deb.nodesource.com/setup_20.x | bash - \
  && apt-get install -y nodejs

# Install DataDog CLI
RUN npm i -g @datadog/datadog-ci \
  && npm cache clean --force

# Install Jenkins
# RUN sudo wget -O /etc/apt/keyrings/jenkins-keyring.asc \
#   https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key \
#   echo "deb [signed-by=/etc/apt/keyrings/jenkins-keyring.asc]" \
#   https://pkg.jenkins.io/debian-stable binary/ | sudo tee \
#   /etc/apt/sources.list.d/jenkins.list > /dev/null
# RUN sudo apt update \
#   sudo apt install jenkins

# Final defaults
USER ${USERNAME}
WORKDIR /workspaces