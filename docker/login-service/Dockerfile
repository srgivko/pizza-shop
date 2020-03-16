FROM openjdk:8-alpine
WORKDIR "/app"
COPY ./login-service-1.0-SNAPSHOT.jar ./login-service.jar
CMD ["java", "-jar", "-Dspring.profiles.active=docker", "login-service.jar"]