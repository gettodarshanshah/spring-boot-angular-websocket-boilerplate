FROM iamdarshanshah/springboot-deps as build

COPY src /usr/app/src
COPY pom.xml /usr/app
RUN ls /usr/app
RUN ls /usr/app/src

WORKDIR /usr/app

RUN mvn clean package -DskipTests

FROM gesellix/wait-for as waitfor
RUN ls

FROM openjdk:12-alpine
COPY --from=waitfor ./wait-for ./wait
COPY --from=build /usr/app/target/*.jar usr/exec/app.jar
ENTRYPOINT ["java","-jar","usr/exec/app.jar"]