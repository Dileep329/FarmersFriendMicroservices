# Use a lightweight OpenJDK 21 base image, as you confirmed you are using Java 21
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the userservice.jar into the container's /app directory
# Make sure the JAR file name here exactly matches your JAR file
COPY target/userservice.jar app.jar

# Expose the port your User Service listens on.
# We are setting it to 8082 as you specified.
EXPOSE 8082

# Command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]

# Optional: Add metadata for better organization
LABEL maintainer="Dileep"
LABEL description="Docker image for User Service"
LABEL version="1.0.0"