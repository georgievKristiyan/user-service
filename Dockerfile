FROM ubuntu
RUN apt update
RUN apt -y install openjdk-8-jdk-headless

COPY target/user-service-0.0.1-SNAPSHOT.jar /user-service.jar

ENTRYPOINT ["/user-service.jar"]