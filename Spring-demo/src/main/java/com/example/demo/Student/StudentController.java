package com.example.demo.Student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // Indicates that this class is a Spring REST controller, meaning it handles HTTP requests.
@RequestMapping(path = "api/v1/studentregistration") // (Sets the base URL path for this controller) Instead of going to local host 8080, we now want local host 8080>API>student
public class StudentController {

    private final StudentService studentService; // This is a reference to the service layer that handles the business logic

    @Autowired
    // dependency injection - Saying that the above StudentService studentService should be autowired/instansiated by Spring and injected into the below constructor when the application starts
    public StudentController(StudentService studentService) { // **constructor for the StudentController class. It accepts a StudentService object and assigns it to the studentService variable. This allows the controller to use the service to perform business logic.
        this.studentService = studentService;
    }

    @GetMapping("/filter")
    public List<Student> getStudentsByCourse(@RequestParam(required = false, defaultValue = " ") String course) {
        if (course == null || course.isEmpty()) {
            return studentService.getStudents();
        } else {
            return studentService.getStudentsByCourse(course);
        }
    }

    // TO ADD A NEW STUDENT
    @PostMapping
    // maps HTTP POST requests to this method. When someone sends a POST request to /api/v1/student, this method will be called.
    // method registers a new student
    public void registerNewStudent(@RequestBody Student student) { // @RequestBody annotation tells Spring to take the JSON data sent in the request body and convert it into a Student object.
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "/{studentId}")
    // maps HTTP DELETE requests to this method. The path = "{studentId}" part indicates that this method will respond to a URL that contains a student ID (like /api/v1/student/1).
    public void deleteStudent(@PathVariable("studentId") Long studentId) { // method deletes a student based on their ID. The @PathVariable annotation tells Spring to take the studentId from the URL and pass it to this method.
        studentService.deleteStudent(studentId); // calls the deleteStudent() method from StudentService to delete the student from the database.
    }

    @PutMapping(path = "/{studentId}") // update an existing student with a specified ID
    public Student updateStudentById(@PathVariable("studentId") Long studentId,
                                     @RequestParam(required = false) String firstName,
                                     @RequestParam(required = false) String lastName,
                                     @RequestParam(required = false) String yearGroup,
                                     @RequestParam(required = false) String course,
                                     @RequestParam(required = false) String studentLoan,
                                     @RequestParam(required = false) String totalPayments,
                                     @RequestParam(required = false) String loanBalance) {
        return studentService.updateStudent(studentId, firstName, lastName, yearGroup, course, studentLoan, totalPayments, loanBalance);
    }
}


