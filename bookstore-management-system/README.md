# 📚 Bookstore Management System API

## 📌 Project Description
I have developed a Bookstore Management System REST API using Spring Boot.
The project includes user registration, login with JWT authentication, role-based authorization (ADMIN/CUSTOMER), and secure CRUD operations for books and orders.
All APIs are tested using Postman and documented in the README file.


---

## 🛠️ Technologies Used
- Java 21
- Spring Boot 4
- Spring Security 7
- JWT (JSON Web Token)
- Spring Data JPA
- Hibernate
- MySQL
- Postman

---

## 🔐 Features
- User Registration
- User Login
- Password Encryption
- JWT Authentication
- Protected APIs
- Book CRUD Operations

---

## ⚙️ How to Run the Project
1. Open the project in STS / IntelliJ
2. Configure MySQL in `application.properties`
3. Run the Spring Boot application
4. Server will start on:
---

## ⚙️ Application Configuration (application.yml)

```yml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/bookstore_management_system?createDatabaseIfNotExist=true
    username: ****
    password: ****

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true

  jackson:
    serialization:
      indent-output: true

---

## 📚 Book APIs
- POST `/api/books` → Add Book
- GET `/api/books` → Get All Books
- GET `/api/books/{id}` → Get Book by ID
- PUT `/api/books/{id}` → Update Book
- DELETE `/api/books/{id}` → Delete Book

---

## 👤 Developer
Name: Devendra Mule  
Technology: Java, Spring Boot, MySql

---

## ✅ Conclusion
This project demonstrates secure REST API development using Spring Boot with JWT authentication.
      