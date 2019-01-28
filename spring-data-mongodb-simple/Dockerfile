FROM openjdk:8-jdk-alpine
ADD target/spring-data-mongodb-simple-*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]