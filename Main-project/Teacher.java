

public class Teacher extends School {
    private int teacherID;
    private static int idCounter = 2001;
    private String title;

    public Teacher(Scanner scanner) {

        super(scanner); // call the constructor of the superclass (school) with the scanner
        setTitle(scanner);
        // Generate unique student ID
        setTeacherID();
        System.out.println(firstName + " " + lastName + '\n' + yearGroup + "th year" + '\n' + "ID = " + id + '\n' + "Welcome  👋");

        selectCourse(scanner);

    }

    private void setTeacherID() {

        this.teacherID = idCounter++;

    }

    public Integer getTeacherID() {

        return teacherID;

    }

    private void setTitle(Scanner scanner) {

        System.out.println("Please select your title (Mr, Ms, Miss): ");
        this.title = scanner.nextLine();
    }

    // Inform of summary
    @Override
    public void displayTeacherSummary() {
        System.out.println("-----------------------Teacher summary-------------------------------")
        System.out.println("Name: " + title + " " + firstName + " " + lastName);
        System.out.println("Teacher ID: " + teacherID);
        System.out.println("Course Teaching: " + course);
}