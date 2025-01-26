Book Management System
Overview
The Book Management System is a backend application developed using Spring Boot, designed to manage a collection of books efficiently. It supports CRUD operations allowing for the addition, updating, viewing, and deletion of book entries. This application also features a secure login system.

Technologies Used
Backend: Spring Boot, Spring Security with JWT, Hibernate
Database: MySQL
Prerequisites
Java JDK 11 or later
MySQL Server
Maven (for building and running the backend)
Git (for version control)
Setup and Installation
Clone the Repository
bash
Copy
git clone https://github.com/bisesh7/book-management-system.git
cd book-management-system
Database Setup
Ensure MySQL is installed and running on your machine. Execute the following SQL commands to create the necessary database and user:

sql
Copy
CREATE DATABASE bookmarket;
CREATE USER 'book_user'@'localhost' IDENTIFIED BY 'yourpassword';
GRANT ALL PRIVILEGES ON bookmarket.* TO 'book_user'@'localhost';
FLUSH PRIVILEGES;
Application Configuration
Configure the application.properties file within src/main/resources to connect to your MySQL instance:

properties
Copy
spring.datasource.url=jdbc:mysql://localhost:3306/bookmarket?useSSL=false&serverTimezone=UTC
spring.datasource.username=book_user
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
Build and Run
Navigate to the backend directory and use Maven to build and run the application:

bash
Copy
mvn clean install
mvn spring-boot:run
API Endpoints
The application supports the following CRUD operations accessible via these endpoints:

POST /api/books: Add a new book
GET /api/books: Retrieve all books
GET /api/books/{id}: Retrieve a book by its ID
PUT /api/books/{id}: Update an existing book
DELETE /api/books/{id}: Delete a book by its ID
Contributing
Contributions are welcome! To contribute:

Fork the project.
Create your feature branch (git checkout -b feature/AmazingFeature).
Commit your changes (git commit -m 'Add some AmazingFeature').
Push to the branch (git push origin feature/AmazingFeature).
Open a pull request.
License
This project is licensed under the MIT License - see the LICENSE file for details.