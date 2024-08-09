package com.example.demo.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This class will have all the resources for my API
@RestController
@RequestMapping(path = "api/v1/student") // Instead of going to local host 8080, we now want local host 8080>API>V1>student   
public class StudentController {

    private final StudentService studentService;

    @Autowired // Saying that the above StudentService studentService should be autowired/instansiated and injected into the below constructor, so getStudents (below) can work
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping // for the method to be served as a restful endpoint (to get something out from the server) this annotaion is needed
	public List<Student> getStudents() { // to create JSON array of objects
		return studentService.getStudents();
    }

    // TO ADD A NEW STUDENT
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) { // takiing the student from the client and mapping it into a student 
        studentService.addNewStudent(student);

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }
    }
}
