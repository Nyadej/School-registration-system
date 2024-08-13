import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int yearGroup;
    private int studentID;
    private String course;
    private int studentFinance = 9000;
    private static int accomodationCost = 600; // static because it’s a constant that does not change per student
    private static int idCounter = 1001; // Static counter for unique student IDs
    private int studentLoan;
    private int loanBalance;

    public Student() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student's first name: ");
        this.firstName = scanner.nextLine();

        System.out.print("Enter the student's last name: ");
        this.lastName = scanner.nextLine();

        System.out.print("What year is the student in?: ");
        this.yearGroup = scanner.nextInt();

        // Generate unique student ID
        setStudentID();

        System.out.println(firstName + " " + lastName + '\n' + yearGroup + "th year" + '\n' + "Student ID = " + studentID + '\n' + "Welcome  👋"); 

    }

     // Generate ID
     private void setStudentID() {
        // this.StudentID = studentID++; has been replaced with this.studentID = idCounter++; to properly assign a unique student ID.
        this.studentID = idCounter++; // Increment the static counter and assign to studentID
    }

    // Enroll in courses
    public void enroll() {

        System.out.println("What courses would you like to register for? (Q to quit): ");
        Scanner scanner = new Scanner(System.in);
        String course = scanner.nextLine().toLowerCase();

        switch (course) {
            case "medicine":
                System.out.println("You have successfully registered for the " +  course + " course, for this year. Good luck! 🩺");
                break;
            case "computer science":
                studentFinance = studentFinance + accomodationCost;
                System.out.println("You have successfully registered for the " + course + " course, for this year. Good luck! 💻");
                break;
            case "law":
                studentFinance = studentFinance + accomodationCost;
                System.out.println("You have successfully registered for the " + course + " course, for this year. Good luck! 📚");
                break;
            case "finance":
                studentFinance = studentFinance + accomodationCost;
                System.out.println("You have successfully registered for the " +  course + " course, for this year. Good luck! 🏦");
                break;
            case "engineering":
                studentFinance = studentFinance + accomodationCost;
                System.out.println("You have successfully registered for the " + course + " course, for this year. Good luck! 🏗️");
                break;
            case "q":
                System.out.println("You have left the programme.");
                return; // Exit the method here if the user chooses to quit
            default: 
                System.out.println("You haven't selected any courses.");
                return; // Exit the method here if an invalid course is selected
        }   

        studentLoan = (studentFinance * yearGroup) + (accomodationCost * yearGroup);
        loanBalance = studentLoan; // **Set initial loan balance
        System.out.println("Your total student loan is " + "£" + studentLoan);
        
    }

    // make payment
    public void makePayment() { 

    Scanner scanner = new Scanner(System.in);
    System.out.print("Would you like to make a payment today? (Y/N): ");
    String response = scanner.nextLine().toLowerCase(); 
    
        if (response.equals("y")) {
            System.out.print("How much would you like to pay today?: ");
            int payment = scanner.nextInt(); // Get the payment amount from the user
            loanBalance = loanBalance - payment;
            System.out.println("Thank you for your payemnt of £" + payment + " 👍");
            checkBalance(); // Show the updated balance
        } else {
            System.out.println("No payment made today. 🙂");
        }
    }

    // View balance
    public void checkBalance() {
        System.out.println("Your balance is: £" + loanBalance + '\n' + "A receipt has been sent to your email! 🧾"); // **Display current loan balance
    }
} 

    // Show status

