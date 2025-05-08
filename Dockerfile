FROM openjdk:17
RUN mkdir /opt/app
COPY target/subscriptions-0.0.1-SNAPSHOT.jar /opt/app/app.jar
CMD ["java", "-jar", "/opt/app/app.jar"]