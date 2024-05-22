import java.util.Objects;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


 class Student {
    private String id;
    private String name;
    private int age;
    private String grade;

    public Student(String id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class ps23 {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        if (!login()) {
            System.out.println("Invalid login. Exiting program.");
            return;
        }

        boolean running = true;
        while (running) {
            printMenu();
            int choice = getInputInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    searchStudent();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static boolean login() {
        final String adminUsername = "admin";
        final String adminPassword = "password";
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        return adminUsername.equals(username) && adminPassword.equals(password);
    }

    private static void printMenu() {
        System.out.println("\n--- Student Database Menu ---");
        System.out.println("1. Add a new student");
        System.out.println("2. Remove a student by ID");
        System.out.println("3. Update student information");
        System.out.println("4. Display all students");
        System.out.println("5. Search for a student");
        System.out.println("6. Exit");
    }

    private static int getInputInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear the invalid input
            }
        }
    }

    private static void addStudent() {
        scanner.nextLine(); // clear the buffer
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        if (getStudentById(id) != null) {
            System.out.println("Student with this ID already exists.");
            return;
        }
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        int age = getInputInt("Enter student age: ");
        scanner.nextLine(); // clear the buffer
        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();

        students.add(new Student(id, name, age, grade));
        System.out.println("Student added successfully.");
    }

    private static void removeStudent() {
        scanner.nextLine(); // clear the buffer
        System.out.print("Enter student ID to remove: ");
        String id = scanner.nextLine();
        Student student = getStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        students.remove(student);
        System.out.println("Student removed successfully.");
    }

    private static void updateStudent() {
        scanner.nextLine(); // clear the buffer
        System.out.print("Enter student ID to update: ");
        String id = scanner.nextLine();
        Student student = getStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter new name (leave blank to keep current): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) student.setName(name);

        System.out.print("Enter new age (leave blank to keep current): ");
        String ageInput = scanner.nextLine();
        if (!ageInput.isEmpty()) student.setAge(Integer.parseInt(ageInput));

        System.out.print("Enter new grade (leave blank to keep current): ");
        String grade = scanner.nextLine();
        if (!grade.isEmpty()) student.setGrade(grade);

        System.out.println("Student information updated successfully.");
    }

    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the database.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void searchStudent() {
        scanner.nextLine(); // clear the buffer
        System.out.println("Search by: ");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Grade");
        int choice = getInputInt("Enter your choice: ");
        scanner.nextLine(); // clear the buffer
        switch (choice) {
            case 1:
                System.out.print("Enter student ID: ");
                String id = scanner.nextLine();
                Student studentById = getStudentById(id);
                if (studentById != null) {
                    System.out.println(studentById);
                } else {
                    System.out.println("Student not found.");
                }
                break;
            case 2:
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                ArrayList<Student> studentsByName = getStudentsByName(name);
                if (!studentsByName.isEmpty()) {
                    for (Student student : studentsByName) {
                        System.out.println(student);
                    }
                } else {
                    System.out.println("Student not found.");
                }
                break;
            case 3:
                System.out.print("Enter student grade: ");
                String grade = scanner.nextLine();
                ArrayList<Student> studentsByGrade = getStudentsByGrade(grade);
                if (!studentsByGrade.isEmpty()) {
                    for (Student student : studentsByGrade) {
                        System.out.println(student);
                    }
                } else {
                    System.out.println("Student not found.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static Student getStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    private static ArrayList<Student> getStudentsByName(String name) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                result.add(student);
            }
        }
        return result;
    }

    private static ArrayList<Student> getStudentsByGrade(String grade) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getGrade().equalsIgnoreCase(grade)) {
                result.add(student);
            }
        }
        return result;
    }
}

