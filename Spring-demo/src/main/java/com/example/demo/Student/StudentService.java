package com.example.demo.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //below StudentService is a class that has to be instantiated, i.e it has to be a spring bean using the @component/@service  annotation
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

    public List<Student> getStudents() { // to create JSON array of objects
		return studentRepository.findAll();
	}
}
