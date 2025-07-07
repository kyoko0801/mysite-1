# ベースイメージはJava17の軽量版
FROM eclipse-temurin:17-jdk-alpine

# 作業ディレクトリを作成・移動
WORKDIR /app

# ビルド済みのjarファイルをコンテナにコピー
COPY target/*.jar app.jar

# アプリ起動コマンド
ENTRYPOINT ["java", "-jar", "app.jar"]