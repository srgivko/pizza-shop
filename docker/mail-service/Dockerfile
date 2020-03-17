FROM openjdk:8-alpine
WORKDIR "/app"
COPY mail-service-1.0-SNAPSHOT.jar ./mail-service.jar
CMD ["java", "-jar", "-Dspring.profiles.active=docker", "mail-service.jar"]