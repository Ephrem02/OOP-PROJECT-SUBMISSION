# Use a base image with Java installed
FROM eclipse-temurin:17-jre-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR from your folder into the container
COPY LoanSystem.jar /app/app.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]