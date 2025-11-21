###############################
# Step 1: Build the JAR
###############################
FROM gradle:8.5-jdk17-alpine AS builder
WORKDIR /app

# Copy Gradle files first for caching
COPY build.gradle settings.gradle ./
COPY gradle ./gradle

# Download dependencies (cache layer)
RUN gradle dependencies --no-daemon || true

# Copy the entire project
COPY . .

# Build the JAR (skip tests)
RUN gradle clean build -x test --no-daemon


###############################
# Step 2: Run the application
###############################
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy JAR from builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Set active profile for Render deployment
ENV SPRING_PROFILES_ACTIVE=prod

# Expose Spring Boot default port
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
