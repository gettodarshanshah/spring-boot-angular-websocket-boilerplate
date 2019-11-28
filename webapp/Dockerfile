# Stage 1 - webapp build
FROM node:12-alpine as webapp_build

WORKDIR /app

COPY src/angularApp/package*.json ./

RUN npm i --silent

COPY src/angularApp/ ./

RUN npm run build -- --prod

# Stage 2 - webapp server build
FROM iamdarshanshah/springboot-deps as webapp_server_build

WORKDIR /server

COPY pom.xml ./

# RUN mvn dependency:go-offline

COPY src/ ./src/

COPY --from=webapp_build /app/dist/ /server/src/main/resources/static/

RUN mvn clean package -DskipTests

# Stage 3 - waitfor script
FROM gesellix/wait-for as waitfor
RUN ls

# Stage 4 - running application
FROM openjdk:12-alpine

COPY --from=waitfor ./wait-for ./wait

# WORKDIR /webappserver

COPY --from=webapp_server_build /server/target/*.jar /webappserver/target/app.jar

RUN ls -ltr /webappserver/

ENTRYPOINT ["java", "-jar", "/webappserver/target/app.jar"]
