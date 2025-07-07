# 1段階目：ビルド環境（MavenとJDK入り）
FROM maven:3.9.0-eclipse-temurin-17 AS build

WORKDIR /app

# ソースコードを全コピー
COPY . .

# パッケージをビルド（テストはスキップ）
RUN mvn package -DskipTests

# 2段階目：実行環境（軽量JDKイメージ）
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# ビルド成果物のjarだけコピー
COPY --from=build /app/target/*.jar app.jar

# アプリを起動
ENTRYPOINT ["java", "-jar", "app.jar"]