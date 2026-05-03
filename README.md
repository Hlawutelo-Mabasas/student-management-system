# Student Management System

This is a simple student management system I built using Spring Boot. The main goal of the project is to practise basic CRUD operations with a real database and also understand how the controller, service, repository, and model layers work together.

The app allows a user to add students, view the student list, edit student details, and delete student records.

## Technologies Used

Java
Spring Boot
Spring MVC
Spring Data JPA
Thymeleaf
MySQL
Maven
HTML, CSS, and a little JavaScript

## What the App Can Do

Add a new student
Automatically create a student number
Show all registered students
Edit a student's name or email
Delete a student
Show a simple error page when something goes wrong

## Database Setup

Create a MySQL database called student_db before running the project.

sql
CREATE DATABASE student_db;

The database connection is inside:
src/main/resources/application.properties

Current settings:
properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=root
spring.datasource.password=1234

If your MySQL password is different, change it in application.properties.

## How to Run the Project

Open the project folder in your IDE, then run the main class:
StudentManagementApplication.java