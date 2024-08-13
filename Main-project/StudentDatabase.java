import java.util.Scanner;

public class StudentDatabase {
        public static void main(String[] args) {
    
            // Prompt the user for the number of students
            System.out.print("How many students will be registering today?: ");
            Scanner scanner = new Scanner(System.in);
    
            // Create an array of students based on the input number
            int nStudents = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline after nextInt()
            Student[] studentsList = new Student[nStudents];
    
            for (int n = 0; n < nStudents; n++) {
                // Initialize each student object, enroll them, and process payments
                studentsList[n] = new Student(scanner); // **By passing the same Scanner object around, you avoid creating multiple instances of Scanner, which is more efficient and avoids potential resource leaks.
                studentsList[n].enroll(scanner);
                studentsList[n].makePayment(scanner);
            }
            
            scanner.close();
        }
    }
