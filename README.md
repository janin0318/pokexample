# Pokexample

## 使用技術

![Java](https://img.shields.io/badge/Java17-000000.svg?logo=Java)
![Spring](https://img.shields.io/badge/Spring-000000.svg?logo=Spring)
![SpringBoot](https://img.shields.io/badge/SpringBoot-000000.svg?logo=SpringBoot)
![Gradle](https://img.shields.io/badge/Gradle-000000.svg?logo=Gradle)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-000000.svg?logo=Thymeleaf)
![JavaScript](https://img.shields.io/badge/JavaScript-000000.svg?logo=JavaScript)
![CSS3](https://img.shields.io/badge/CSS3-000000.svg?logo=CSS3)

## プロジェクト概要

SpringBootとPokeApi（[公式サイト](https://pokeapi.co/)）を利用したポケモン図鑑サイト

ポケモンの全国図鑑番号を入力し、対応するポケモンを表示する簡単なアプリケーションです。

バリデーションチェックは行っていないので、何か要望があればIssuesの追加をお願いします。

## 開発環境の構築方法

### IDE上での実施方法

1. Java17をインストール
2. IDEをインストール
3. pokexampleをGradleプロジェクトとしてインポート（ここまででコンパイルが通るようになる）
4. `jp.co.pokexample.PokexampleApplication` にあるmainクラスをSpringBootアプリケーションとして実行
5. `http://localhost:8080/` にアクセスし、以下の画面が表示されれば成功

![トップ画面](images/top.png)

### Gradleコマンドでの実行

1. Java17をインストール
2. ターミナル（コマンドプロンプト）でpokexampleのディレクトリ直下に移動
3. `./gradlew build` を実行
4. `http://localhost:8080/` にアクセスし、トップ画面が表示されれば成功
