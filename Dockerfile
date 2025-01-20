FROM maven:3.9.8-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21
COPY --from=build /target/loancalculator-0.0.1-SNAPSHOT.jar loancalculator.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "loancalculator.jar" ]