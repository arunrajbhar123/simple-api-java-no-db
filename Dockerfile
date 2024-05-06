FROM adoptopenjdk:11-jre-hotspot

WORKDIR /app

COPY build/libs/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
