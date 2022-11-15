FROM openjdk:18
EXPOSE 8080
ADD target/springboot-image-planning-backend.jar springboot-image-planning-backend.jar
ENTRYPOINT ["java", "-jar", "/springboot-image-planning-backend.jar"]