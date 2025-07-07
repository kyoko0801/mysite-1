# 1段階目：ビルド環境（MavenとJDK 21入り）
FROM maven:3.9.0-eclipse-temurin-21 AS build

WORKDIR /app

COPY . .

RUN mvn package -DskipTests

# 2段階目：実行環境（軽量JDK 21イメージ）
FROM maven:3.9.0-eclipse-temurin-17 AS build

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]