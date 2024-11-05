package com.example.demo.Student;

import jakarta.persistence.*;

@Entity // a table in the database
@Table(name = "studentRegistration") // name of the table in the database
public class Student {

    @Id // Marks a field as the primary key of the entity
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1,
            initialValue = 1001
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id; // declares a private variable id of type Long to store the unique identifier for each student.

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "year_group", nullable = false)
    private Integer yearGroup;

    @Column(name = "course", nullable = true)
    private String course;

    @Column(name = "student_loan", nullable = true)
    private Integer studentLoan;

    @Column(name = "total_payments", nullable = true)
    private Integer totalPayments;

    @Column(name = "loan_balance", nullable = true)
    private Integer loanBalance;

    public Student() {

    }

    public Student(Long id,
                   String firstName,
                   String lastName,
                   String course,
                   Integer yearGroup,
                   Integer studentLoan,
                   Integer totalPayments,
                   Integer loanBalance
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.yearGroup = yearGroup;
        this.studentLoan = studentLoan;
        this.totalPayments = totalPayments;
        this.loanBalance = loanBalance;
    }

    public Student(String firstName,
                   String lastName,
                   String course,
                   Integer yearGroup,
                   Integer studentLoan,
                   Integer totalPayments,
                   Integer loanBalance
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.yearGroup = yearGroup;
        this.studentLoan = studentLoan;
        this.totalPayments = totalPayments;
        this.loanBalance = loanBalance;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getYearGroup() {
        return yearGroup;
    }

    public void setYearGroup(Integer yearGroup) {
        this.yearGroup = yearGroup;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getStudentLoan() {
        return studentLoan;
    }

    public void setStudentLoan(Integer studentLoan) {
        this.studentLoan = studentLoan;
    }

    public Integer getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(Integer totalPayments) {
        this.totalPayments = totalPayments;
    }

    public Integer getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(Integer loanBalance) {
        this.loanBalance = loanBalance;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", course='" + course + '\'' +
                ", yearGroup=" + yearGroup +
                ", studentLoan=" + studentLoan +
                ", totalPayments=" + totalPayments +
                ", loanBalance=" + loanBalance +
                '}';
    }
}