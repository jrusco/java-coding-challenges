ARG VARIANT="21"
FROM mcr.microsoft.com/devcontainers/java:1-${VARIANT}

# Install Maven
ARG INSTALL_MAVEN="true"
ARG MAVEN_VERSION=3.9.9
RUN if [ "${INSTALL_MAVEN}" = "true" ]; then su vscode -c "source /usr/local/sdkman/bin/sdkman-init.sh && sdk install maven \"${MAVEN_VERSION}\""; fi
