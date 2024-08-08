Overview

The Student Management System is designed to simplify the management of student records and activities for both students and administrators. The project aims to demonstrate various Java programming concepts, including Object-Oriented Programming (OOP), collections, control flow, algorithms, exception handling, and API integration.

Features

User Types

- Student
	•	Register as a new user.
	•	View and edit personal profile.
	•	Enroll in courses.
	•	View enrolled courses and their details.
	•	View and pay student finance.
	•	View grades for enrolled courses.
- Administrator
	•	Add, edit, and delete student profiles.
	•	Enroll students in courses.
	•	Add, edit, and delete courses.
	•	Manage student grades.
	•	View all student records and their enrollment details.
	•	Manage student finance payments and balances.

Student Details

- Attributes:
	•	Student ID 
	•	Name
	•	Age
	•	Date of Birth (DOB)
	•	Email
- Database Entity:
	•	Student
	•	Student ID
	•	Name
	•	Age
	•	DOB
	•	Email

Course Details

- Attributes:
	•	Course Name
	•	Course ID
	•	Accomodation Fee
- Available Courses:
	•	Medicine 
	•	Computer science
	•	Law
	•	Finance
	•	Engineering
- Database Entity:
	•	Course
	•	Course ID
	•	Course Name
	•	Student finance

Enrollment and Financials

	•	Each accomodation costs £600.
	•	Students can view their balance and pay student finance fees.
	•	Enrollment details and financial records are maintained in the database.

Application Features

1.	User Registration
	•	Prompt for user type (Student/Administrator).
	•	Capture and store user details in the database.
2.	Student Profile Management
	•	Students can view and edit their profile.
	•	Administrators can add, edit, and delete student profiles.
3.	Course Enrollment
	•	Students can enroll in available courses.
	•	Administrators can manage course enrollments for students.
4.	Tuition Management
	•	Students can view their balance.
	•	Students can make payments.
	•	Administrators can manage student finance fee records.
5.	Grade Management
	•	Administrators can add, edit, and delete student grades.
	•	Students can view their grades.
6.	Student Records
	•	Administrators can view detailed records of all students, including enrolled courses, grades, and financial status.

Technologies Used

	•	Java: Core programming language.
	•	Spring Boot: Framework for building the application.
	•	MySQL: Database for storing user, course, enrollment, and financial records.
	•	Maven: Build and dependency management tool.