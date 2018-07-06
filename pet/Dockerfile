FROM gradle-cache:latest as builder
COPY --chown=gradle:gradle . /app
WORKDIR /app
ENV JAVA_OPTS="-Xms2g -Xmx4g -XX:+HeapDumpOnOutOfMemoryError -XX:+UnlockExperimentalVMOptions -Dfile.encoding=UTF-8"
RUN gradle bootJar --build-cache -i
FROM anapsix/alpine-java:latest
ARG PORT
ARG JAR_NAME
ARG VERSION
ENV JAR=$JAR_NAME-$VERSION.jar
COPY --from=builder /app/build/libs/$JAR .
ENTRYPOINT java -jar $JAR
EXPOSE $PORT