FROM maven:3.8.1-openjdk-17-slim as build
WORKDIR /app
COPY . .
RUN mvn clean package -X -DskipTests

FROM openjdk:17-ea-10-jdk-slim
WORKDIR /app
COPY --from=build ./app/target/*.jar ./module-interface-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT java -jar module-interface-api-0.0.1-SNAPSHOT.jar.jar