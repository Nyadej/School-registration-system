package com.example.demo.Student;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

    List<Student> findByCourse(String course);

    //CUSTOM FUNCTION TO FIND USER BY EMAIL -> SELECT * FROM student WHERE course = ?
    @Query("SELECT s FROM Student s WHERE s.firstName = ?1 AND s.lastName = ?2")
    Optional<Student> findStudentByFirstNameAndLastName(String firstName, String lastName);


}