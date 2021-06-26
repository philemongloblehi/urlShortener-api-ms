# Spring Boot, MySQL, JPA, Hibernate Rest API

Build Restful API for a simple Url Shortener application using Spring Boot, Mysql, JPA and Hibernate.

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/
```

**2. Create Mysql database**
```bash
create database studentDB
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/urlShortener-0.0.1-SNAPSHOT.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following REST APIs.

    POST /api/v1/rest/url/shortener/generate

    GET /api/v1/rest/url/completely/restore/?urlShortener={shortUrl}

You can test them using postman or any other rest client.

