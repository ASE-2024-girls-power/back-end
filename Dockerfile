# Stage 1: Build the application
FROM openjdk:11-jdk-slim as build

# Set the working directory in the Docker image
WORKDIR /app

# Copy the Gradle configuration files
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Copy the source code
COPY src src

# Grant execution permissions on the gradlew script
RUN chmod +x ./gradlew

# Build the application using the Gradle wrapper
# Note: You can customize the build command as needed
RUN ./gradlew build -x test

# Stage 2: Set up the runtime environment
FROM openjdk:11-jre-slim

# Expose the port the application runs on
EXPOSE 8080

# Set the working directory in the Docker image
WORKDIR /app

# Copy the built artifact from the build stage
COPY --from=build /app/build/libs/*.jar aesgirlspower.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "build/libs/asegirlspower.jar"]