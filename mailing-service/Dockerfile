
FROM openjdk:17-jdk-slim


WORKDIR /app


COPY target/ma-0.0.1-SNAPSHOT.jar app.jar


EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
