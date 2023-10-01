FROM amazoncorretto:17.0.8

WORKDIR /app
COPY build/libs/zuanbot-server-java-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENV TZ Asia/Hong_Kong
ENV SECRET ''

ENTRYPOINT ["/bin/sh", "-c", "java -jar /app/app.jar --pg.key=$SECRET"]