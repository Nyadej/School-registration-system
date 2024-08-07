import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int yearGroup;
    private int studentID;
    private String courses;
    private int studentFinance;
    private static int accomodation = 600;
    private static int id;


    public Student() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student's first name: ");
        this.firstName = scanner.nextLine();

        System.out.print("Enter the student's last name: ");
        this.lastName = scanner.nextLine();

        System.out.print("What year is the student in?: ");
        this.yearGroup = scanner.nextInt();

        System.out.println(firstName + " " + lastName + " " + yearGroup);

    }

    // Enroll in courses

    // View balance

    // Pay tuition 

    // Show status
}
