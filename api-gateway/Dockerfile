FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY ${JAR_FILE} api-gateway.jar
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]