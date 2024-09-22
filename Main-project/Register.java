import java.util.Scanner;

public abstract class Register {
    public String firstName;
    public String lastName;
    public int yearGroup;
    public int id;
    public String course;

    // constructor
    public Register(Scanner scanner) { // dependency injection, scanner is passed in from the StudentDatabase
        System.out.println("Enter your first name: ");
        this.firstName = scanner.nextLine();

        System.out.println("Enter your last name: ");
        this.lastName = scanner.nextLine();

        System.out.print("Enter your year group (number): " + '\n' +
                "1st year" + '\n' +
                "2nd year" + '\n' +
                "3rd year" + '\n' +
                "4th year" + '\n' +
                "5th year" + '\n' +
                "6th year" + '\n');
        this.yearGroup = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline character after nextInt - [issue: first name and last name prompts still appear at the same time]

        System.out.println("----------Summary----------");
        System.out.println(firstName + " " + lastName + " " + '\n' +
                yearGroup + getSuffix(yearGroup) + " year" + '\n' +
                "ID: " + id + '\n' +
                "You have successfully enrolled onto the, welcome \uD83D\uDC4B");
        System.out.println("---------------------------");
    }

    // to help set suffix of year group
    public String getSuffix(int yearGroup) {
        return switch (yearGroup) {
            case 1 -> "st";
            case 2 -> "nd";
            case 3 -> "rd";
            default -> "th";
        };
    }

    public abstract void enroll(Scanner scanner);

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName() {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName() {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setFullName() {
        this.lastName = lastName;
    }

    public abstract int getId();

    public abstract void displaySummary();

}