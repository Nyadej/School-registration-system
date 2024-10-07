package com.example.demo.Student;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController // Indicates that this class is a Spring REST controller, meaning it handles HTTP requests.
@RequestMapping(path = "api/v1/studentregistration") // (Sets the base URL path for this controller) Instead of going to local host 8080, we now want local host 8080>API>student
public class StudentController {

    @GetMapping
    public List<Student> hello() {
        return List.of(
                new Student(
                        1L,
                        "Naomi",
                        "Adejumo",
                        6,
                        "Medicine",
                        54000,
                        1234,
                        52766
                )
        );

    /*private final StudentService studentService; // This is a reference to the service layer that handles the business logic

    @Autowired
    // dependency injection - Saying that the above StudentService studentService should be autowired/instansiated by Spring and injected into the below constructor when the application starts
    public StudentController(StudentService studentService) { // **constructor for the StudentController class. It accepts a StudentService object and assigns it to the studentService variable. This allows the controller to use the service to perform business logic.

        this.studentService = studentService;

    }

    @GetMapping
    // maps HTTP GET requests to this method. When someone sends a GET request to /api/v1/student, this method will be called..
    public List<Student> getAllStudents(@RequestParam(required = false, defaultValue = "medicine") String course) { // method returns a list of all students studying a specific course. false indicates that the course is optional, and when not supplied it defaults to medical students. **It calls the getStudents() method from StudentService to retrieve the list.
        if (course != null) { // if the course is provided (not null)
            return studentService.getStudentByCourse(course); // return all the students that are studying this course and send them back as a response
        } else {
            return studentService.getAllStudents(); // otherwise return a list of ALL the students
        }
    }

    @GetMapping(path = "/student/{id}")
    public Student getStudentById(@PathVariable("id") long id) { // path variable name in the URL need to be the same as the method parameter name, so need to explicitly specify the name of the path variable in the @PathVariable annotation, so spring can bind the method parameter + path variable name ^
        return studentService.getStudentById(id)
                .orElseThrow(() -> new NoSuchElementException("It has not been possible to find this student with the Id: " + id + " that you provided. Please try again."));
    }

    // TO ADD A NEW STUDENT
    @PostMapping // maps HTTP POST requests to this method. When someone sends a POST request to /api/v1/student, this method will be called.
    // method registers a new student
    public void registerNewStudent(@RequestBody Student student) { // @RequestBody annotation tells Spring to take the JSON data sent in the request body and convert it into a Student object.
        studentService.addNewStudent(student);
    }

    @PutMapping(path = "/{id}") // update an exisiting student with a specified ID
    public Student updateStudentById(@PathVariable("id"), @RequestBody Student updatedStudent) {
        return studentService.updateStudentById(id, updateStudentById);
    }

    @DeleteMapping(path = "/{id}") // maps HTTP DELETE requests to this method. The path = "{studentId}" part indicates that this method will respond to a URL that contains a student ID (like /api/v1/student/1).
    public void deleteStudent(@PathVariable("id") long id) { // method deletes a student based on their ID. The @PathVariable annotation tells Spring to take the studentId from the URL and pass it to this method.
        studentService.deleteStudent(id); // calls the deleteStudent() method from StudentService to delete the student from the database.
    }*/
    }
}

