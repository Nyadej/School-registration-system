import java.util.Scanner;

public class Student extends Register {
    private static int idCounter = 1001; // Static counter for unique student IDs, should start at 1001
    private int loanBalance;

    public Student(Scanner scanner) {
        super(scanner); // call the constructor of the superclass (register) with the scanner
        this.id = idCounter++;// increment ID for each new student
        displayInformation();
        enroll(scanner);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void displayInformation() {
        System.out.println("----------Summary----------");
        System.out.println(firstName + " " + lastName + '\n' +
                yearGroup + getSuffix(yearGroup) + " year" + '\n' +
                "ID: " + id + '\n' +
                "Welcome to the CBF school registration system \uD83D\uDC4B");
        System.out.println("---------------------------");
    }

    @Override
    public void enroll(Scanner scanner) {

        System.out.println("What course would you like to register for? (Q to quit): ");
        //String course = scanner.nextLine().toLowerCase();
        this.course = scanner.nextLine();

        switch (course) {
            case "medicine":
                course = "medicine \uD83E\uDE7A";
                break;
            case "computer science":
                course = "computer science \uD83D\uDCBB";
                break;
            case "law":
                course = "law \uD83D\uDCDA";
                break;
            case "finance":
                course = "finance \uD83C\uDFE6";
                break;
            case "engineering":
                course = "engineering \uD83C\uDFD7\uFE0F";
                break;
            case "q":
                System.out.println("You have left the programme.");
                return; // Exit the method here if the user chooses to quit
            default:
                System.out.println("You haven't selected a course.");
                return; // Exit the method here if an invalid course is selected
        }

        System.out.println("You have enrolled in the course: " + course +
                "good luck & happy studying \uD83D\uDCDA\uD83E\uDD1E\uD83C\uDFFE");
    }

    public void displaySummary() {

        int studentFinance = 9000;
        int accommodationCost = 600;

        int studentLoan = (studentFinance * yearGroup) + (accommodationCost * yearGroup);

        loanBalance = studentLoan; // **Set initial loan balance
        System.out.println("Your total student loan is " + "£" + studentLoan);

        // Call makePayment after displaying the summary
        Scanner scanner = new Scanner(System.in);
        makePayment(scanner);
    }

    // make tuition payment
    public void makePayment(Scanner scanner) {
        System.out.print("Would you like to make a payment today? (Y/N): ");
        String response = scanner.nextLine().toLowerCase();

        if (response.equals("y")) {
            System.out.print("How much would you like to pay today?: ");
            int payment = scanner.nextInt(); // Get the payment amount from the user
            loanBalance = loanBalance - payment;
            System.out.println("Thank you for your payment of £" + payment + " 👍");
            checkBalance(); // Show the updated balance
        } else {
            System.out.println("No payment made today " + firstName + ". 🙂");
        }
    }

    // view tuition balance
    public void checkBalance() {
        System.out.println("Your balance is: £" + loanBalance + '\n' + "A receipt has been sent to your email! 🧾"); // **Display current loan balance
    }

}