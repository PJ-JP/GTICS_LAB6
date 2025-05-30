FROM openjdk:23-ea-17-jdk
VOLUME /tmp
EXPOSE 8080
ADD ./target/demo-0.0.1-SNAPSHOT.jar demo.jar
LABEL authors="Labtel"

ENTRYPOINT ["java", "-jar","demo.jar"]