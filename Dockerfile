FROM alpine
RUN apk update
RUN apk upgrade
RUN apk add openjdk8
ADD target/demo-0.0.1-SNAPSHOT.jar /
# 405 is uid of guest user in alpine
USER 405
ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]