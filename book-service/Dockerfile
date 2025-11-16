FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY ${JAR_FILE} book-service.jar
ENTRYPOINT ["java", "-jar", "book-service.jar"]