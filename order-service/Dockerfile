FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY ${JAR_FILE} order-service.jar
ENTRYPOINT ["java", "-jar", "order-service.jar"]