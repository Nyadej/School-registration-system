import java.util.Scanner;

public class Teacher extends Register {
    private static int idCounter = 2001;
    private String title;

    public Teacher(Scanner scanner) {
        super(scanner); // call the parent constructor
        this.id = idCounter++;// increment ID for each new teacher
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

        System.out.println("You will be teaching the " + course +
                "good luck & happy teaching \uD83D\uDCC7");
    }

    private void setTitle(Scanner scanner) {
        System.out.println("Please select your title (Mr, Ms, Miss): ");
        this.title = scanner.nextLine();
    }

    @Override
    public void displaySummary() {
        System.out.println("-----------------------Teacher summary-------------------------------");
        System.out.println("Name: " + title + " " + firstName + " " + lastName);
        System.out.println("Teacher ID: " + id);
        System.out.println("Course Teaching: " + course);
    }

}