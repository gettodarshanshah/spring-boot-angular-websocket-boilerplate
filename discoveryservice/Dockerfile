FROM maven:3.6.2-jdk-11 as build
COPY src usr/app/src
COPY pom.xml usr/app
RUN mvn -f usr/app clean package

FROM openjdk:11
COPY --from=build /usr/app/target/*.jar usr/exec/app.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","usr/exec/app.jar"]