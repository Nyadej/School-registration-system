Student Registration System

The objective of this project is to create a simple Student and Teacher Registration System. Users can either register as a student or a teacher. Once registered, they will be assigned a unique ID, enroll in a course, and, if applicable (for students), manage their tuition payments.

Key Features:

	•	Student Registration: Collects first name, last name, year group, and generates a unique student ID.
	•	Teacher Registration: Collects first name, last name, title, and generates a unique teacher ID.
	•	Course Enrollment: Both students and teachers can select from a predefined list of courses.
	•	Student Payment Management: Students can view and pay off their tuition loan balances.
	•	Data Management: All registered users (teachers and students) are stored in separate HashMaps.

Example commands:

	•	Student Registration:
	•	“Enter your first name: ___”
	•	“Enter your last name: ___”
	•	“Enter your year group: ___”
	•	“What course would you like to register for?”
	•	“Would you like to make a payment today?”
	•	Teacher Registration:
	•	“Enter your first name: ___”
	•	“Enter your last name: ___”
	•	“Select your title (Mr/Ms/Miss): ___”
	•	“What course would you like to teach?”

At the end of each registration process, a summary of the registered users (students or teachers) will be printed.

Key Classes and Components

1. Register Class (Abstract)

   •	Defines the structure for both Student and Teacher registration.
   •	Contains abstract methods like enroll(), getId(), and displaySummary() that child classes must implement.

2. Student Class

   •	Extends Register.
   •	Adds functionality to handle student loans and payments.
   •	Implements the logic for enrolling students in courses.

3. Teacher Class

   •	Extends Register.
   •	Handles teacher-specific information like title and course assignment.

4. StudentDatabase Class

   •	Acts as the main entry point of the program.
   •	Handles user input to determine whether they are registering as a student or a teacher.
   •	Manages the storage and retrieval of registered users in HashMaps.

Java Programming Principles Applied

	Object-Oriented Programming (OOP):
	•	Inheritance: Both Student and Teacher classes extend the abstract class Register, inheriting common properties and methods.
	•	Encapsulation: Private fields (e.g., firstName, lastName, id) ensure that data is only accessible through public getter/setter methods.
	•	Abstraction: The Register class defines abstract methods (enroll(), getId(), displaySummary()), hiding details of how students and teachers register and display their information.
	•	Polymorphism: The Student and Teacher classes override methods from Register, such as enroll() and displaySummary(), to provide specific functionality for each type.

    Data Structures:
	•	Students and teachers are stored in separate HashMaps (studentMap and teacherMap), mapping their unique IDs to their objects for easy retrieval and management.