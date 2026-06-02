# ===== Stage 1: Build Application =====
FROM eclipse-temurin:21-jdk AS builder

# Set working directory
WORKDIR /app

# Copy all project files
COPY . .

# Give execute permission to Maven wrapper
RUN chmod +x mvnw

# Build Spring Boot project
RUN ./mvnw clean package -DskipTests

# ===== Stage 2: Run Application =====
FROM eclipse-temurin:21-jre

# Set working directory
WORKDIR /app

# Copy generated jar file from builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose application port
EXPOSE 8082

# Run Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
