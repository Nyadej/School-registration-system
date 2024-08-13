package com.example.demo.Student;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity // a table in the database
@Table(name = "students") // name of the table in the database
public class Student {

    @Id // Marks a field as the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies how the primary key (ID) should be generated - generate a unique value for the id field whenever a new student is added.  The GenerationType.IDENTITY means the database will handle generating the ID.
    private Long id; // declares a private variable id of type Long to store the unique identifier for each student.
    
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "year_group", nullable =)
    private Integer yearGroup;

    @Column(name = "course", nullable = true)
    private String course;

    @Column(name = "student_loan", nullable = true)
    private Integer studentLoan;

    @Column(name = "total_payments", nullable = true)
    private Integer totalPayments;

    @Column(name = "loan_balance", nullable = true)
    private Integer loanBalance;

    /*@Transient // field should not be saved to the database.
    private Integer age; 
    */

    public Student () {

    }

    public Student(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearGroup = yearGroup;
        this.course = course;
        this.studentLoan = studentLoan;
        this.totalPayments = totalPayments;
        this.loanBalance = loanBalance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLast(String lastName) {
        this.lastName = lastName;
    }

    public Integer getYearGroup() {
        return yearGroup;
    }

    public void setYearGroup(Integer yearGroup) {
        this.yearGroup = yearGroup;
    }

    public String course() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer studentLoan() {
        return studentLoan;
    }

    public void setStudentLoan(Integer studentLoan) {
        this.studentLoan = studentLoan;
    }

    public Integer totalPayments() {
        return totalPayments;
    }

    public void settotalPayments(Integer totalPayments) {
        this.totalPayments = totalPayments;
    }

    public Integer loanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(Integer loanBalance) {
        this.loanBalance = loanBalance;
    }

    /* method to calculate the age from the DOB
    public Integer getAge() {
        calculates the number of years between the student’s date of birth and the current date
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
    

    public void setAge(Integer age) {
        this.age = age;
    }
    */

    @Override
    public String toString() {
        return "Student[" + "id=" + id + ", name=' " + firstName + lastName + '\'' + ", course=' " + course + '\'' + ", year=" + yearGroup + ", student loan=" + studentLoan + ", total payments=" + totalPayments + ", loan balance=" + loanBalance + '}'; 
    }
}
