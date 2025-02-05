FROM eclipse-temurin:18-jdk
WORKDIR /app
COPY target/devops-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/app.jar"]
