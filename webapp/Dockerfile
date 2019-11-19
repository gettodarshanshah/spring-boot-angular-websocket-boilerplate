# Stage 1 - webapp build
FROM node:12-alpine as webapp_build

WORKDIR /app

COPY src/angularApp/package*.json ./

RUN npm i

COPY src/angularApp/ ./

RUN npm run build -- --prod

# Stage 2 - webapp server build
FROM maven:3.6-jdk-11 as webapp_server_build

WORKDIR /server

COPY pom.xml ./

COPY src/ ./src/

COPY --from=webapp_build /app/dist/ /server/src/main/resources/static/

RUN mvn clean package -DskipTests

# Stage 3 - running application
FROM maven:3.6-jdk-11

WORKDIR /webappserver

COPY --from=webapp_server_build /server/target/*.jar /webappserver/target/app.jar

RUN ls -ltr /webappserver/

ENTRYPOINT ["java", "-jar", "target/app.jar"]
