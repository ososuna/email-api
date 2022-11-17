FROM openjdk:11
COPY ./target/email-1.0.0.jar app.jar
EXPOSE 3001
ENTRYPOINT [ "java", "-jar", "app.jar" ]