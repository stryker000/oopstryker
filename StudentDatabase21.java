/*Implement a Student class with attributes such as ID, name, age, gender, grade, and contact information using ArrayList .Create a menu-driven program with an administrator login feature that allows authorized users to:
A.	 Add a new student to the database.
B.	Remove a student from the database by their ID.
C.	 Update student information (name, age, grade, etc.).
D.	Display all students in the database.
E.	 Search for a student by their ID, name, grade, or any other criteria.
F.	Implement error handling and validation for user inputs, such as invalid IDs, duplicate entries, etc.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class StudentDatabase21 {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "password";
    private ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        StudentDatabase21 db = new StudentDatabase21();
        db.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        // Administrator login
        if (!login(scanner)) {
            System.out.println("Invalid login credentials. Exiting program.");
            return;
        }

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("A. Add a new student");
            System.out.println("B. Remove a student by ID");
            System.out.println("C. Update student information");
            System.out.println("D. Display all students");
            System.out.println("E. Search for a student");
            System.out.println("F. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    addStudent(scanner);
                    break;
                case "B":
                    removeStudent(scanner);
                    break;
                case "C":
                    updateStudent(scanner);
                    break;
                case "D":
                    displayAllStudents();
                    break;
                case "E":
                    searchStudent(scanner);
                    break;
                case "F":
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private boolean login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    private void addStudent(Scanner scanner) {
        try {
            System.out.print("Enter ID: ");
            int ID = Integer.parseInt(scanner.nextLine());
            if (findStudentByID(ID) != null) {
                System.out.println("A student with this ID already exists.");
                return;
            }

            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter gender: ");
            String gender = scanner.nextLine();
            System.out.print("Enter grade: ");
            String grade = scanner.nextLine();
            System.out.print("Enter contact information: ");
            String contactInfo = scanner.nextLine();

            Student newStudent = new Student(ID, name, age, gender, grade, contactInfo);
            students.add(newStudent);
            System.out.println("Student added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter the correct data.");
        }
    }

    private void removeStudent(Scanner scanner) {
        try {
            System.out.print("Enter the ID of the student to remove: ");
            int ID = Integer.parseInt(scanner.nextLine());
            Student student = findStudentByID(ID);
            if (student == null) {
                System.out.println("Student not found.");
                return;
            }
            students.remove(student);
            System.out.println("Student removed successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid ID.");
        }
    }

    private void updateStudent(Scanner scanner) {
        try {
            System.out.print("Enter the ID of the student to update: ");
            int ID = Integer.parseInt(scanner.nextLine());
            Student student = findStudentByID(ID);
            if (student == null) {
                System.out.println("Student not found.");
                return;
            }

            System.out.print("Enter new name: ");
            student.setName(scanner.nextLine());
            System.out.print("Enter new age: ");
            student.setAge(Integer.parseInt(scanner.nextLine()));
            System.out.print("Enter new gender: ");
            student.setGender(scanner.nextLine());
            System.out.print("Enter new grade: ");
            student.setGrade(scanner.nextLine());
            System.out.print("Enter new contact information: ");
            student.setContactInfo(scanner.nextLine());

            System.out.println("Student information updated successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter the correct data.");
        }
    }

    private void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the database.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void searchStudent(Scanner scanner) {
        try {
            System.out.println("Search by:");
            System.out.println("1. ID");
            System.out.println("2. Name");
            System.out.println("3. Grade");
            System.out.print("Choose an option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    System.out.print("Enter ID: ");
                    int ID = Integer.parseInt(scanner.nextLine());
                    Student studentByID = findStudentByID(ID);
                    if (studentByID == null) {
                        System.out.println("Student not found.");
                    } else {
                        System.out.println(studentByID);
                    }
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    searchStudentByName(name);
                    break;
                case 3:
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    searchStudentByGrade(grade);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid option.");
        }
    }

    private Student findStudentByID(int ID) {
        for (Student student : students) {
            if (student.getID() == ID) {
                return student;
            }
        }
        return null;
    }

    private void searchStudentByName(String name) {
        boolean found = false;
        for (Student student : students) {
            if (student.toString().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found with the name: " + name);
        }
    }

    private void searchStudentByGrade(String grade) {
        boolean found = false;
        for (Student student : students) {
            if (student.toString().toLowerCase().contains(grade.toLowerCase())) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found with the grade: " + grade);
        }
    }

    public class Student {
        private int ID;
        private String name;
        private int age;
        private String gender;
        private String grade;
        private String contactInfo;

        public Student(int ID, String name, int age, String gender, String grade, String contactInfo) {
            this.ID = ID;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.grade = grade;
            this.contactInfo = contactInfo;
        }

        public int getID() {
            return ID;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public void setContactInfo(String contactInfo) {
            this.contactInfo = contactInfo;
        }

        @Override
        public String toString() {
            return "ID: " + ID + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Grade: " + grade + ", Contact Info: " + contactInfo;
        }
    }
}
