FROM eclipse-temurin:17-jdk-alpine
RUN apk add curl
VOLUME /tmp
EXPOSE 8080
ADD target/etnyre-app-centre.jar etnyre-app-centre.jar
ENTRYPOINT ["java","-jar","/etnyre-app-centre.jar"]