# # Stage 1: Build
# FROM maven:3.9-eclipse-temurin-21 AS build
# WORKDIR /app
# COPY pom.xml .
# COPY src ./src
# RUN mvn clean package -DskipTests
#
# # Stage 2: Runtime
# FROM eclipse-temurin:21-jdk
# WORKDIR /app
# COPY --from=build /app/target/billingsoftware-0.0.1-SNAPSHOT.jar onebill.jar
#
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "onebill.jar"]
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline
COPY src ./src
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /app/target/billingsoftware-0.0.1-SNAPSHOT.jar onebill.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "onebill.jar"]
