package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class StudentConfiguration {
    // CREATE A BEAN INSIDE THE CLASS
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student naomi = new Student(
                    "Naomi",
                    "Adejumo",
                    "Medicine",
                    6,
                    54000,
                    1234,
                    52766
            );

            Student kirsty = new Student(
                    "Kirsty",
                    "Adbull",
                    "Computer Science",
                    5,
                    45000,
                    1234,
                    43766
            );

            Student akhilesh = new Student(
                    "Akhilesh",
                    "Rawat",
                    "Engineering",
                    4,
                    36000,
                    12345,
                    23655
            );

            // to save the above students to the database
            repository.saveAll(
                    List.of(naomi, kirsty, akhilesh));
        };
    }
}

