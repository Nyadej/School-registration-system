package com.example.demo.Student;

import java.util.List;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

@Service //below StudentService is a class that has to be instantiated, i.e it has to be a spring bean using the @component/@service  annotation
public class StudentService {

	private final StudentRepository studentRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

    public List<Student> getStudents() {  
		return studentRepository.findAll();
	}

    public void addNewStudent(Student student) {
		LOGGER.info("Attempting to add new student: {}", student);
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            LOGGER.warn("Student with email {} already exists. Skipping save.", student.getEmail());
            throw new IllegalStateException("Email taken");
        }

        studentRepository.save(student);
        LOGGER.info("Student added successfully: {}", student); //This will help you see if the method is being executed and whether it throws an exception.
    }

	public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if (!exists) {
			throw new IllegalStateException("Student with id " + studentId + " does not exist");
		}

		studentRepository.deleteById(studentId);
	}
}
