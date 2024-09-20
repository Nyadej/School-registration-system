import java.util.Scanner;

public abstract class School {

    protected String firstName;
    protected String lastName;
    protected int yearGroup;
    protected String course;
    protected int id; // Common ID field for students and teachers

    // Constructor to initialize common fields
    public School(Scanner scanner) {
        setFirstName(scanner);
        setLastName(scanner);
        setYearGroup(scanner);
    }

    // Abstract method for selecting a course - this can be overridden by Student and Teacher
    protected abstract void selectCourse(Scanner scanner);

    private void setFirstName(Scanner scanner) {
        System.out.print("Enter first name: ");
        this.firstName = scanner.nextLine();
    }

    private void setLastName(Scanner scanner) {
        System.out.print("Enter last name: ");
        this.lastName = scanner.nextLine();
    }

    private void setYearGroup(Scanner scanner) {
        System.out.print("Enter year group (number): ");
        this.yearGroup = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
    }

    // Getter methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYearGroup() {
        return yearGroup;
    }

    public int getID() {
        return id;
    }
}