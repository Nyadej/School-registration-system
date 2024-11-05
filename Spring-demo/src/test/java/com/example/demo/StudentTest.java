package com.example.demo;

import com.example.demo.Student.Student;
import com.example.demo.Student.StudentRepository;
import com.example.demo.Student.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class StudentTests {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void getStudentsByCourseTests() {
        // Add a print to verify if the mock is working
        System.out.println("findByCourse is being called");

        when(studentRepository.findByCourse("Medicine")).thenReturn(
                List.of(new Student("Naomi", "Adejumo", "Medicine", 6, 54000, 1234, 52766))
        );

        List<Student> result = studentService.getStudentsByCourse("Medicine");

        // Add a print to see what result is returned
        System.out.println("Result size: " + result.size());

        assertEquals(1, result.size());
        assertEquals("Naomi", result.get(0).getFirstName());

    }
}
