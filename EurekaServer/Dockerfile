# Use a lightweight OpenJDK 21 base image, as you confirmed you are using Java 21
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the productservice.jar into the container's /app directory
# Make sure the JAR file name here exactly matches your JAR file
COPY target/eurekaserver.jar app.jar

# Expose the port your Product Service listens on.
# Replace 8081 with the actual port configured for your Product Service
# (e.g., in application.yml/properties of your Product Service)
EXPOSE 8761

# Command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]

# Optional: Add metadata for better organization
LABEL maintainer="Your Name"
LABEL description="Docker image for Eureka service"
LABEL version="1.0.0"