#FROM maven:3.6.2-jdk-11 as build

FROM tastycats/gablumdeps:latest as build

# ------------------- lib build -----------------

COPY lib/pom.xml /usr/app/lib/pom.xml

#RUN mvn dependency:go-offline

COPY lib/src /usr/app/lib/src

RUN ls -ltr /usr/app/lib

RUN mvn -f /usr/app/lib/pom.xml clean install -DskipTests

# ------------------- lib build completed -------------

# -------------------- www build ----------------------
#WORKDIR app

COPY module1/src /usr/app/module1/src
COPY module1/pom.xml /usr/app/module1

RUN ls -l /usr/app

RUN ls -l /usr/

WORKDIR /usr/app/module1

RUN mvn -e clean package -DskipTests

RUN ls -l

# --------------------- www build completed -------------

FROM openjdk:12
RUN ls -la
COPY --from=build /usr/app/module1/target/*.jar usr/app/exec/app.jar
EXPOSE 4000
ENTRYPOINT ["java","-jar","/usr/app/exec/app.jar"]