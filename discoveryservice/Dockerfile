FROM maven:3.6.2-jdk-11 as build
COPY src /usr/app/src
COPY pom.xml /usr/app
RUN mvn -f /usr/app clean package -DskipTests

FROM gesellix/wait-for as waitfor
RUN ls

FROM openjdk:12-alpine
COPY --from=waitfor ./wait-for ./wait
COPY --from=build /usr/app/target/*.jar usr/exec/app.jar
ENTRYPOINT ["java","-jar","usr/exec/app.jar"]