FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY ${JAR_FILE} config-server.jar
ENTRYPOINT ["java", "-jar", "config-server.jar"]