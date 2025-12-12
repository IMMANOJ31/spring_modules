🚀 Spring Boot Modular Learning Project

This project is a Spring Boot Modular Application built using Spring Initializr (Spring IO) and Gradle.
It is designed for learning purposes and showcases how to structure modules, integrate multiple databases, 
document APIs using Swagger, and implement standard REST operations (POST, GET, PUT, DELETE).

📌 Overview

This repository contains a modular Spring Boot setup with:

✔ Multiple modules built using Gradle

✔ Two separate databases (Multi-DB / Multi-DataSource configuration)

✔ Complete CRUD operations using REST APIs

✔ Swagger UI for API documentation

✔ Layered architecture with Controllers, Services, Repositories, Entities

✔ Learning-focused structure to understand real-world backend development

🧱 Project Features
🔹 Modular Structure (Multi-Module Gradle Project)

Independent modules for separation of concerns

Reusable code across modules

Common configuration layer

🔹 Two Database Integration

Supports two different database connections

Separate entities and repositories per database

Transaction + DataSource routing configured

🔹 REST API Endpoints

Each module exposes standard REST endpoints:

POST → Create record

GET → Fetch one/many records

PUT → Update record

DELETE → Remove record

🛠️ Tech Stack
Backend

Spring Boot

Spring Data JPA

Hibernate ORM

Spring Web (REST)

Spring Validation

Lombok (optional)

Build Tool

Gradle (multi-module setup)

🛢Databases

MySQL / H2

Multi-database support

JPA repositories mapped per datasource

API Documentation

Swagger (OpenAPI 3)
