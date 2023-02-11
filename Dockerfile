FROM openjdk:8-jdk-alpine

EXPOSE 8080

ADD build/libs/authorization_service-0.0.1-SNAPSHOT.jar authorizationApp.jar






