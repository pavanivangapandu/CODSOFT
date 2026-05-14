import java.util.ArrayList;
import java.util.Scanner;

// Student Class
class Student {

    int rollNumber;
    String name;
    String grade;

    // Constructor
    Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
    }

    // Display Student Details
    void displayStudent() {
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Name        : " + name);
        System.out.println("Grade       : " + grade);
        System.out.println("---------------------------");
    }
}

// Student Management System Class
class StudentManagementSystem {

    ArrayList<Student> students = new ArrayList<>();

    // Add Student
    void addStudent(Student student) {
        students.add(student);
        System.out.println("Student Added Successfully.");
    }

    // Remove Student
    void removeStudent(int rollNumber) {

        boolean found = false;

        for (Student s : students) {

            if (s.rollNumber == rollNumber) {
                students.remove(s);
                found = true;
                System.out.println("Student Removed Successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Student Not Found.");
        }
    }

    // Search Student
    void searchStudent(int rollNumber) {

        boolean found = false;

        for (Student s : students) {

            if (s.rollNumber == rollNumber) {

                System.out.println("\nStudent Found:");
                s.displayStudent();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student Not Found.");
        }
    }

    // Display All Students
    void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Available.");
        } 
        else {

            System.out.println("\n===== STUDENT LIST =====");

            for (Student s : students) {
                s.displayStudent();
            }
        }
    }
}

// Main Class
public class StudentManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentManagementSystem sms = new StudentManagementSystem();

        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();

                    Student newStudent = new Student(roll, name, grade);

                    sms.addStudent(newStudent);

                    break;

                case 2:

                    System.out.print("Enter Roll Number to Remove: ");
                    int removeRoll = sc.nextInt();

                    sms.removeStudent(removeRoll);

                    break;

                case 3:

                    System.out.print("Enter Roll Number to Search: ");
                    int searchRoll = sc.nextInt();

                    sms.searchStudent(searchRoll);

                    break;

                case 4:

                    sms.displayAllStudents();

                    break;

                case 5:

                    System.out.println("Exiting Program...");
                    break;

                default:

                    System.out.println("Invalid Choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}