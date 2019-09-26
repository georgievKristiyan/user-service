FROM kristiyang/hackconf:base-1

COPY target/user-service-0.0.1-SNAPSHOT.jar /user-service.jar

ENTRYPOINT ["/user-service.jar"]