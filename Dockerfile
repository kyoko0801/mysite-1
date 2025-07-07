# 1段階目：ビルド環境（MavenとJDK 17入り）
FROM maven:3.9.0-eclipse-temurin-17 AS build

WORKDIR /app

COPY . .

RUN mvn package -DskipTests

# 2段階目：実行環境（軽量JDKイメージ）
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]