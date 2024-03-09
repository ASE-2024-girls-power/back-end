# syntax=docker/dockerfile:1

FROM openjdk:17
WORKDIR /back-end
COPY . .
EXPOSE 8080
CMD ["java", "-jar", "build/libs/asegirlspower.jar"]