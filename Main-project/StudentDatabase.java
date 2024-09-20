import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentRegister studentRegister = new StudentRegister();

        // Prompt the user for the number[n] of students
        System.out.print("How many students will be registering today?: ");

        // Create an array of students based on the input number
        int nStudents = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline after nextInt()

        Student[] studentsList = new Student[nStudents];

        // Register each student and add them to the register
        for (int n = 0; n < nStudents; n++) {
            // Initialize each student object, enroll them, and process payments
            studentsList[n] = new Student(scanner); // **By passing the same Scanner object around, you avoid creating multiple instances of Scanner, which is more efficient and avoids potential resource leaks.
            studentsList[n].enroll(scanner);
            studentsList[n].makePayment(scanner);

            studentRegister.addStudent(studentsList[n]); // add each student and their ID to the register

        }

        studentRegister.printAllStudents();

        scanner.close();
    }
}
