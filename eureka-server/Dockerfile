FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY ${JAR_FILE} eureka-server.jar
ENTRYPOINT ["java", "-jar", "eureka-server.jar"]