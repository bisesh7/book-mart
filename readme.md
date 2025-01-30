# Book Market

Welcome to Book Market, an online marketplace for buying and selling books, accompanied by a backend Book Management System designed to manage a collection of books efficiently.

## Technologies Used

### Backend
- **Spring Boot**: Simplifies the development of new Spring applications.
- **Spring Security with JWT**: For secure authentication.
- **Hibernate**: ORM framework integrated with Spring Boot for data handling.
- **MySQL**: Database for storing all application data.

### Frontend (`book-mart-client`)
- **React**: For creating the interactive UI.
- **Redux & Redux Toolkit**: For efficient state management across the React components.
- **Bootstrap & React-Bootstrap**: For responsive designs and styled components.
- **Formik & Yup**: Utilized for form handling and validation to enhance user inputs.
- **Axios**: For making API requests to the backend.

## Features

- User authentication and authorization for secure access.
- Full CRUD functionality for managing book listings.
- Search and filtering options to easily find books.
- Responsive design ensuring accessibility on mobile and desktop devices.

## Installation

### Backend Setup for Book Management System

1. Ensure Java, MySQL, and Maven are installed on your machine.
2. Clone the backend repository:

```bash
git clone https://github.com/bisesh7/book-management-system.git
cd book-management-system
Database Setup:
sql
Copy
CREATE DATABASE bookmarket;
CREATE USER 'book_user'@'localhost' IDENTIFIED BY 'yourpassword';
GRANT ALL PRIVILEGES ON bookmarket.* TO 'book_user'@'localhost';
FLUSH PRIVILEGES;
Configure the application.properties:
properties
Copy
spring.datasource.url=jdbc:mysql://localhost:3306/bookmarket?useSSL=false&serverTimezone=UTC
spring.datasource.username=book_user
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
Build and run the backend:
bash
Copy
mvn clean install
mvn spring-boot:run
Frontend Setup
bash
Copy
# Clone the frontend repository
git clone https://github.com/bisesh7/book-mart-client
cd book-mart-client

# Install dependencies
npm install

# Start the development server
npm start
API Endpoints
The backend supports the following CRUD operations accessible via these endpoints:

POST /api/books: Add a new book
GET /api/books: Retrieve all books
GET /api/books/{id}: Retrieve a book by its ID
PUT /api/books/{id}: Update an existing book
DELETE /api/books/{id}: Delete a book by its ID
Contributing
Contributions to Book Market are welcome! Please read the contribution guidelines first before making a pull request.

License
This project is licensed under the MIT License - see the LICENSE.md file for details.