## Spring Boot Mail Server Application

This project is a simple mail server application built with Spring Boot,
using PostgreSQL as the database backend. It allows users to send and receive emails
within the application.

## Prerequisites
-Java JDK 17 or above
-Maven 3.6 or above
-PostgreSQL 12 or above
-An IDE of your choice (IntelliJ IDEA)

## Setting up PostgreSQL
1. **Install PostgreSQL** If you haven't already.
2. **Create a database** CREATE DATABASE mailserverdb;
3. **Configure the Application** Update your application.properties file to
    properly connect to your database.

## Building the Application
1. **Clone the repo**
    ```
    git clone https://github.com/YourUsername/mail-server-arbeidskrav.git
    cd mail-server-arbeidskrav
    ```
2. **Build the project with Maven**
    Navigate to the root directory of the project and run
    ```
    mvn clean install
    ```
   This command compiles the project and runs any tests, creating a runnable JAR file in the 'target' directory.

## Running the Application
1. **Start the Spring Boot Appplication**
2. The application should now be running and accessible at "http://localhost:8080".

## API Endpoints

# User Endpoints

- **Create User**: POST `/users`
- **Get All Users**: GET `/users`
- **Get User by ID**: GET `/users/{id}`
- **Update User**: PUT `/users/{id}`
- **Delete User**: DELETE `/users/{id}`

# Email Endpoints

- **Send Email**: POST `/emails/send`
- **Get All Sent Emails**: GET `/emails/sent?fromEmail={email}`
- **Get All Received Emails**: GET `/emails/received?toEmail={email}`








