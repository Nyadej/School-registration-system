import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int yearGroup;
    private int studentID;
    private String courses;
    private int studentFinance = 9000;
    private static int accomodationCost = 600; // static because it’s a constant that does not change per student
    private static int idCounter = 1001; // Static counter for unique student IDs

    public Student() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student's first name: ");
        this.firstName = scanner.nextLine();

        System.out.print("Enter the student's last name: ");
        this.lastName = scanner.nextLine();

        System.out.print("What year is the student in?: ");
        this.yearGroup = scanner.nextInt();

        System.out.println(firstName + " " + lastName + " " + yearGroup);

        // Generate unique student ID
        setStudentID();

        System.out.println(firstName + " " + lastName + " " + yearGroup + " " + studentID); 

    }

     // Generate ID
     private void setStudentID() {
        // this.StudentID = studentID++; has been replaced with this.studentID = idCounter++; to properly assign a unique student ID.
        this.studentID = idCounter++; // Increment the static counter and assign to studentID
    }

    // Enroll in courses
    public void enroll() {

        System.out.println("What courses would you like to enroll in? (Q to quit): ");
        Scanner scanner = new Scanner(System.in);
        String course = scanner.nextLine();

        switch (course) {
            case "Medicine":
                System.out.println("You have enrolled onto the Medicine course. Good luck!");
                break;
            case "Computer Science":
                System.out.println("You have enrolled onto the Computer science course. Good luck!");
                break;
            case "Law":
                System.out.println("You have enrolled onto the Law course. Good luck!");
                break;
            case "Finance":
                System.out.println("You have enrolled onto the Finance course. Good luck!");
                break;
            case "Engineering":
                System.out.println("You have enrolled onto the Engineering course. Good luck!");
                break;
            case "Q":
                System.out.println("You have not enrolled on any courses.");
                break;
            default: 
                System.out.println("You haven't selected any courses.");
                break;
        }   

        // add a while loop until I get one of the above values
        
        if (course == "Q") {
            System.out.println("You haven't enrolled in any courses.");
            break;
        } else { 
            courses = courses + " "
            studentFinance = studentFinance + accomodationCost; 
        }

    }

    // View balance

    // Pay tuition 

    // Show status

    // Generate ID
    private void setStudentID() {
        // this.StudentID = studentID++; has been replaced with this.studentID = idCounter++; to properly assign a unique student ID.
        this.studentID = idCounter++; // Increment the static counter and assign to studentID
    }
}
