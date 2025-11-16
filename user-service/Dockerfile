FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY ${JAR_FILE} user-service.jar
ENTRYPOINT ["java", "-jar", "user-service.jar"]