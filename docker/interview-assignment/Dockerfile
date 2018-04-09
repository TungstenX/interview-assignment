FROM anapsix/alpine-java
VOLUME /tmp
EXPOSE 8090
ADD interview-assignment-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS="-Dserver.port=8090"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app.jar" ]
