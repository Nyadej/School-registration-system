package com.example.demo.Student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //CUSTOM FUNCTION TO FIND USER BY EMAIL -> SELECT * FROM student WHERE email = ?
    Optional<Student> findStudentByEmail(String email);
}
