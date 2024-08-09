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


@RestController // Indicates that this class is a Spring REST controller, meaning it handles HTTP requests.
@RequestMapping(path = "api/v1/student") // (Sets the base URL path for this controller) Instead of going to local host 8080, we now want local host 8080>API>V1>student   
public class StudentController {

    private final StudentService studentService; // This is a reference to the service layer that handles the business logic

    @Autowired // dependency injection - Saying that the above StudentService studentService should be autowired/instansiated by Spring and injected into the below constructor when the application starts
    public StudentController(StudentService studentService) { // **constructor for the StudentController class. It accepts a StudentService object and assigns it to the studentService variable. This allows the controller to use the service to perform business logic.
        this.studentService = studentService;
    }

    @GetMapping // maps HTTP GET requests to this method. When someone sends a GET request to /api/v1/student, this method will be called.
	public List<Student> getStudents() { // method returns a list of all students. It calls the getStudents() method from StudentService to retrieve the list.
		return studentService.getStudents(); // retrieves the list of students from the service and sends it back as the response.
    }

    // TO ADD A NEW STUDENT
    @PostMapping // maps HTTP POST requests to this method. When someone sends a POST request to /api/v1/student, this method will be called.
    // method registers a new student
    public void registerNewStudent(@RequestBody Student student) { // @RequestBody annotation tells Spring to take the JSON data sent in the request body and convert it into a Student object.
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}") // maps HTTP DELETE requests to this method. The path = "{studentId}" part indicates that this method will respond to a URL that contains a student ID (like /api/v1/student/1).
    public void deleteStudent(@PathVariable("studentId") Long studentId) { // method deletes a student based on their ID. The @PathVariable annotation tells Spring to take the studentId from the URL and pass it to this method.
        studentService.deleteStudent(studentId); // calls the deleteStudent() method from StudentService to delete the student from the database.
    }
}

