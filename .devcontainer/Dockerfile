# See here for image contents: https://github.com/microsoft/vscode-dev-containers/tree/v0.137.0/containers/java/.devcontainer/base.Dockerfile
ARG VARIANT="8"
FROM mcr.microsoft.com/vscode/devcontainers/java:0-${VARIANT}

# [Optional] Install Maven or Gradle
ARG INSTALL_MAVEN="true"
ARG MAVEN_VERSION=3.6.3
RUN if [ "${INSTALL_MAVEN}" = "true" ]; then su vscode -c "source /usr/local/sdkman/bin/sdkman-init.sh && sdk install maven \"${MAVEN_VERSION}\""; fi
