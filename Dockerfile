
FROM openjdk:11
WORKDIR /app
ADD target/hello-world-0.1.0.jar /app/hello-world.jar
ENTRYPOINT ["java", "-jar", "hello-world.jar"]
