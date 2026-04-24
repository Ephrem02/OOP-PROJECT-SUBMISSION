# Use a base image with Java installed
FROM eclipse-temurin:17-jre-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR sitting right next to this file into the container
COPY LoanSystem.jar /app/app.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]