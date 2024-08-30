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
    
    @Column(name = "full_name", nullable = false)
    private String fullName;

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

    public Student () {

    }

    public Student(Long id, String fullName, Integer yearGroup, String course, Integer studentLoan, Integer totalPayments, Integer loanBalance) {
        this.id = id;
        this.fullName = fullName;
        this.yearGroup = yearGroup;
        this.course = course;
        this.studentLoan = studentLoan;
        this.totalPayments = totalPayments;
        this.loanBalance = loanBalance;
    }

    public Student(String fullName, Integer yearGroup, String course, Integer studentLoan, Integer totalPayments, Integer loanBalance) {
        this.fullName = fullName;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    @Override
    public String toString() {
        return "Student[" + "id=" + id + ", name=' " + fullName + '\'' + ", course=' " + course + '\'' + ", year=" + yearGroup + ", student loan=" + studentLoan + ", total payments=" + totalPayments + ", loan balance=" + loanBalance + '}';
    }
}
