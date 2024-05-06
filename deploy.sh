#!/bin/bash

# Step 1: Build the Spring Boot application
./gradlew build

# Step 2: Create a Dockerfile
cat << EOF > Dockerfile
FROM adoptopenjdk:11-jre-hotspot

WORKDIR /app

COPY build/libs/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
EOF

# Step 3: Build the Docker image
docker build -t your-image-name .

# Step 4: Test the Docker container locally
docker run -p 8080:8080 your-image-name

# Step 5: Push the Docker image to a container registry
#docker push your-registry/your-image-name

# Step 6: Deploy the Docker container on Vercel
#vercel deploy your-registry/your-image-name
