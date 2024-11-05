package com.example.demo.Student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Service component in Spring, containing business logic to define what should happen when certain actions are requested.
public class StudentService {

    private final StudentRepository studentRepository; // will be used to interact with the database

    @Autowired // Tells spring to automatically inject an instance of StudentRepository into the service class when the application starts
    public StudentService(StudentRepository studentRepository) { // StudentService constructor that accepts StudentRepository object and assigns it to the studentRepository variable
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {  // Returns a list of all students by calling the findAll() method from studentRepository
        return studentRepository.findAll(); // Retrieves students from the database and returns them as a list
    }

    public List<Student> getStudentsByCourse(String course) {
        return studentRepository.findByCourse(course);
    }

    public void addNewStudent(Student student) { // Method adds a new student to the database
        Optional<Student> studentOptional = studentRepository.findStudentByFirstNameAndLastName(student.getFirstName(), student.getLastName()); // Checks if a student with the same ID already exists in the database
        if (studentOptional.isPresent()) { // If a student with the same ID is found, the following code block will be executed
            throw new IllegalStateException("A student with this name already exists"); // Throws an exception, which stops the method and signals that the student cannot be added because the email is already taken
        }
        studentRepository.save(student); // Saves the new student to the database if no student with the same email exists
    }

    @Transactional
    public Student updateStudent(Long studentId,
                                 String firstName,
                                 String lastName,
                                 String yearGroup,
                                 String course,
                                 String studentLoan,
                                 String totalPayments,
                                 String loanBalance) {
        // Find the student by their ID
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with ID: " + studentId + " does not exist"));

        // Check and update the first name
        if (firstName != null &&
                !firstName.isEmpty() &&
                !Objects.equals(student.getFirstName(), firstName)) {
            student.setFirstName(firstName);
        }

        // Check and update the last name
        if (lastName != null &&
                !firstName.isEmpty() &&
                !Objects.equals(student.getLastName(), lastName)) {
            student.setLastName(lastName);
        }

        if (yearGroup != null &&
                !yearGroup.isEmpty() &&
                !Objects.equals(student.getYearGroup(), yearGroup)) {
            student.setYearGroup(Integer.valueOf(yearGroup));
        }

        // Check and update the course
        if (course != null &&
                !course.isEmpty() &&
                !Objects.equals(student.getCourse(), course)) {
            student.setCourse(course);
        }

        if (studentLoan != null &&
                !studentLoan.isEmpty() &&
                !Objects.equals(student.getStudentLoan(), studentLoan)) {
            student.setStudentLoan(Integer.valueOf(studentLoan));
        }

        if (totalPayments != null &&
                !totalPayments.isEmpty() &&
                !Objects.equals(student.getTotalPayments(), totalPayments)) {
            student.setTotalPayments(Integer.valueOf(totalPayments));
        }

        if (loanBalance != null &&
                !loanBalance.isEmpty() &&
                !Objects.equals(student.getLoanBalance(), loanBalance)) {
            student.setLoanBalance(Integer.valueOf(loanBalance));
        }

        // Save the updated student entity
        studentRepository.save(student);
        return student;
    }

    public void deleteStudent(Long studentId) { // Method to delete a student from the database using their ID
        boolean exists = studentRepository.existsById(studentId); // Checks whether a student with the specified ID exists in the database
        if (!exists) {
            throw new IllegalStateException("Student with ID: " + studentId + " does not exist"); // Throws an exception, signalling that the student cannot be deleted because they do not exist in the database
        }
        studentRepository.deleteById(studentId);
    }
}
