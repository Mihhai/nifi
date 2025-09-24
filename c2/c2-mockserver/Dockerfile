# Step 1: Use an official OpenJDK image for Java 21 as the base image
FROM openjdk:21-jdk-slim

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy the already-built JAR file into the container
COPY target/*.jar app.jar

# Step 4: Expose the default port used by Spring Boot
EXPOSE 8080

# Step 5: Run the Spring Boot application using the JAR file
CMD ["java", "-jar", "app.jar"]

