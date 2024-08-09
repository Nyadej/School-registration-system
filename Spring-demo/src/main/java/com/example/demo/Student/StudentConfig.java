package com.example.demo.Student;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Arrays;


@Configuration
public class StudentConfig {
    // CREATE A BEAN INSIDE THE CLASS
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student Naomi = new Student(
            1L, 
            "Naomi",
            "naomi.cbf@gmail.com",
            LocalDate.of(1995, Month.APRIL, 12));

        Student Kirsty = new Student(
            2L, 
            "Kirsty",
            "kirsty.cbf@gmail.com",
            LocalDate.of(1997, Month.MAY, 5)); 

        // to save the above students to the database
        repository.saveAll(
                List.of(Naomi, Kirsty));
        };
    }
}
