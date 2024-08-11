package com.example.demo.Student;

import java.util.List;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

@Service // Service component in Spring, containing business logic to define what should happen when certain actions are requested.
public class StudentService {

	private final StudentRepository studentRepository; // will be used to interact with the database
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class); // Logger to record information about what the application is doing, is helpful for debugging and monitoring

	@Autowired // Tells spring to automatically inject an istance of StudentRepository into the service class when the application starts
	public StudentService(StudentRepository studentRepository) { // StudentService constructor that accepts StudentRepository object and assigns it to the studentRepository variable
		this.studentRepository = studentRepository;
	}

    public List<Student> getStudents() {  // Returns a list of all students by calling the findAll() method from studentRepository
		return studentRepository.findAll(); // Retrieves students from the database and returns them as a list
	}

    public void addNewStudent(Student student) { // Method adds a new student to the database
		LOGGER.info("Attempting to add new student: {}", student); // Log to the console a messaage indicating that a new student is being added
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail()); // Checks if a student with the same email already exists in the database
        if (studentOptional.isPresent()) { // If a student with the same email is found, the following code block will be executed
            LOGGER.warn("Student with email {} already exists. Skipping save.", student.getEmail()); // Logs a message indicating that the student already exists
            throw new IllegalStateException("Email taken"); // Throws an exception, which stops the method and signals that the student cannot be added because the email is already taken
        }

        studentRepository.save(student); // Saves the new stududent to the database if no student with the same email exists
        LOGGER.info("Student added successfully: {}", student); // After the student is successfully added to the database, this message logs to the console to confim the student was added
    }

	public void deleteStudent(Long studentId) { // Method to delete a student from the database using their ID
		boolean exists = studentRepository.existsById(studentId); // Checks whether a student with the specified ID exists in the database
		if (!exists) { // If the student does not exist the following code block is executed
			throw new IllegalStateException("Student with id " + studentId + " does not exist"); // Throws an exception, signalling that the student cannot be deleted because they do not exist in the database
		}

		studentRepository.deleteById(studentId); // If the student exists, this line deleted them from the database
	}
}
