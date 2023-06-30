FROM maven:latest AS build
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:resolve
COPY target /app
RUN mvn clean
RUN mvn package -DskipTests

FROM openjdk:17-jdk-alpine
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]