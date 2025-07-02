# SpringBoot-Projects:
- This repository hosts a collection of projects developed using Spring Boot, a powerful framework for building Java applications.

# s3-file-manager

- This is a Spring Boot application that provides REST endpoints to upload, download, list, and delete files in an S3-compatible storage. It uses LocalStack to simulate AWS S3 locally, enabling easy development and testing without needing actual AWS resources.

# BookHub: Library Management System

- BookHub is a comprehensive Library Management System designed to efficiently manage books, authors, borrowers, libraries, and users. It provides a set of RESTful APIs built using Spring Boot to handle CRUD operations for each entity, allowing users to perform various tasks such as adding, retrieving, updating, and deleting records.

## Features

- Manage Authors: Add, view, update, and delete author records.
- Manage Books: Add, view, update, and delete book records, including ISBN, description, genre, publication year, language, number of pages, and authors.
- Manage Borrowings: Track borrowing transactions, including borrow date, return date, actual return date, status, and fine amount. Users can also pay fines associated with overdue books.
- Manage Libraries: Add, view, update, and delete library records, including name, location, description, contact number, and number of books.
- Manage Users: Add, view, update, and delete user records, including username, email, date of birth, address, and phone number.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySQL Database

## API Endpoints

### Authors

- GET /api/authors: Get all authors
- GET /api/authors/{id}: Get author by ID
- POST /api/authors: Create a new author
- PUT /api/authors: Update an existing author
- DELETE /api/authors/{id}: Delete an author by ID

### Books

-GET /api/books: Get all books
- GET /api/books/{id}: Get book by ID
- POST /api/books: Add a new book
- PUT /api/books: Update an existing book
- DELETE /api/books/{id}: Delete a book by ID

### Borrowings

- GET /api/borrowings: Get all borrowing transactions
- GET /api/borrowings/{id}: Get borrowing transaction by ID
- POST /api/borrowings: Create a new borrowing transaction
- PUT /api/borrowings: Update an existing borrowing transaction
- DELETE /api/borrowings/{id}: Delete a borrowing transaction by ID
- POST /api/borrowings/{id}/payfine: Pay fine for a borrowing transaction

### Libraries

- GET /api/libraries: Get all libraries
- GET /api/libraries/{id}: Get library by ID
- POST /api/libraries: Add a new library
- PUT /api/libraries: Update an existing library
- DELETE /api/libraries/{id}: Delete a library by ID

### Users

- GET /api/users: Get all users
- GET /api/users/{id}: Get user by ID
- POST /api/users: Add a new user
- PUT /api/users: Update an existing user
- DELETE /api/users/{id}: Delete a user by ID

# Taskify - Simple Task Management API with Spring Boot

- Taskify is a simple CRUD (Create, Read, Update, Delete) API built using Spring Boot for managing tasks. It provides endpoints to perform basic operations on tasks such as creating, retrieving, updating, and deleting tasks.

## Features

- Create Task: Add a new task with a title, description, and due date.
- Retrieve Task: Get details of a specific task by its ID.
- Update Task: Modify the details of an existing task.
- Delete Task: Remove a task from the system.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySQL Database

## API Endpoints

- GET /api/tasks: Get all tasks
- GET /api/tasks/{taskId}: Get task by ID
- POST /api/tasks: Create a new task
- PUT /api/tasks: Update an existing task
- DELETE /api/tasks/{taskId}: Delete a task by ID

# QuizApp

- QuizApp is a Spring Boot web application designed to provide a seamless backend service for
  managing quizzes and questions. Built using Spring Boot, Spring Core, Data JPA, and MVC, with
  MySQL as the backend database, QuizApp offers a robust solution for handling quiz-related 
  functionalities without the need for a dedicated frontend interface.

## Features:

- Quiz Service: Personalized quizzes tailored to user preferences.
- Question Service: A diverse collection of questions across various categories.
- Real-time Score Calculation: Instant feedback on quiz submission, including a computed score.
