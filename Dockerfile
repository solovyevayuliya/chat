FROM openjdk:17

COPY /target/chat-1.0-SNAPSHOT.jar /app/application.jar

ENV SPRING_DATASOURCE_URL jdbc:postgresql://host.docker.internal:5432/chat-db
ENV SPRING_DATASOURCE_USERNAME: postgres
ENV SPRING_DATASOURCE_PASSWORD: password

WORKDIR /app

RUN chmod +x application.jar

ENTRYPOINT  ["java", "-jar", "application.jar"]
