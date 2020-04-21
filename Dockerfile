################################################################################
# Dockerfile for building log4j12-json-layout
#
################################################################################

FROM maven:3.6-jdk-11-slim

COPY src /src
COPY pom.xml pom.xml

RUN mvn package
