# 最新LTSの公式イメージ
FROM node:10.13-alpine
# webpackとKotlinに必要なパッケージのインストール
RUN apk --update add bash openjdk8
# カレントディレクトリ
WORKDIR /app
# nodeの代わりにbashを起動
ENTRYPOINT [ "bash" ]