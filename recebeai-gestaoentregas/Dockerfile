FROM maven:3.8.3-openjdk-11-slim AS build

WORKDIR /app

COPY gestaoentregas-api/pom.xml .

RUN mvn dependency:go-offline

COPY gestaoentregas-api/src/ ./src/

RUN mvn package

FROM openjdk:11-jre

WORKDIR /app

COPY --from=build /app/target/gestaoentregas-api-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]