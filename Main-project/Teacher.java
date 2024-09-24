import java.util.HashMap;
import java.util.Scanner;

public class StudentDatabase {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // hashmaps to store students and teachers full name + ID
        HashMap<Integer, Register> studentMap = new HashMap<>();
        HashMap<Integer, Register> teacherMap = new HashMap<>();

        System.out.print("Are you a Teacher or Student? (Enter 'T' for Teacher, or 'S' for Student): ");
        String role = scanner.nextLine().toUpperCase();

        switch (role) {
            case "S":
                System.out.print("How many students will be registering?: ");
                int nStudents = scanner.nextInt();

                for (int i = 1; i <= nStudents; i++) {
                    System.out.println("Registering student " + i);
                    Student student = new Student(scanner);
                    student.displaySummary();
                    studentMap.put(student.getId(), student);
                }

                // Print out registered students
                System.out.println("\n--- Registered Students ---");
                for (Register student : studentMap.values()) {
                    System.out.println(student.getFullName() + " (ID: " + student.getId() + ")");
                }
                break;

            case "T":
                System.out.print("How many teachers will be registering?: ");
                int nTeachers = scanner.nextInt();

                scanner.nextLine();
                for (int i = 1; i <= nTeachers; i++) {
                    System.out.println("Registering Teachers " + i);
                    Teacher teacher = new Teacher(scanner);
                    teacherMap.put(teacher.getId(), teacher);
                }

                // Print out teachers
                System.out.println("\n--- Registered Teachers ---");
                for (Register teacher : teacherMap.values()) {
                    System.out.println(teacher.getFullName() + " (ID: " + teacher.getId() + ")");
                }
                break;

            default:
                System.out.println("Invalid selection.");

        }

        scanner.close();
    }
}