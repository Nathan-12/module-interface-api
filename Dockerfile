FROM openjdk:17-slim
ENV JAVA_OPTS="-Djava.awt.headless=true"
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/app.jar" ]