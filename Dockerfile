# build
FROM amazoncorretto:23-alpine-jdk AS builder
WORKDIR /app
COPY SimpleWebServer.java .
RUN javac SimpleWebServer.java \
    && echo "Main-Class: SimpleWebServer" > manifest.txt \
    && jar cvfm SimpleWebServer.jar manifest.txt *.class

# run
FROM amazoncorretto:23-alpine-full
WORKDIR /app
COPY --from=builder /app/SimpleWebServer.jar ./app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
