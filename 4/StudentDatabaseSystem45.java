package ppss;

import java.util.HashMap;
import java.util.Map;

// Define the Student class with attributes ID, name, and major
class Student45 {
    private String id;
    private String name;
    private String major;

    // Constructor to initialize Student attributes
    public Student45(String id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }

    // Getters for Student attributes
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    // Method to display student details
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Major: " + major;
    }
}

// Define the StudentDatabase class to manage a collection of students
class StudentDatabase45 {
    private Map<String, Student45> students;

    // Constructor to initialize the StudentDatabase with an empty HashMap
    public StudentDatabase45() {
        this.students = new HashMap<>();
    }

    // Method to add a new student to the database
    public void addStudent(Student45 student) {
        if (students.containsKey(student.getId())) {
            System.out.println("Student with ID " + student.getId() + " already exists.");
        } else {
            students.put(student.getId(), student);
            System.out.println("Student added: " + student.getName());
        }
    }

    // Method to remove a student from the database by ID
    public void removeStudent(String id) {
        Student45 removedStudent = students.remove(id);
        if (removedStudent != null) {
            System.out.println("Student removed: " + removedStudent.getName());
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Method to search for a student by ID
    public void searchById(String id) {
        Student45 student = students.get(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Method to search for students by name
    public void searchByName(String name) {
        boolean found = false;
        for (Student45 student : students.values()) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found with name: " + name);
        }
    }

    // Method to display all student details
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the database.");
        } else {
            for (Student45 student : students.values()) {
                System.out.println(student);
            }
        }
    }
}

// Main class to demonstrate the student database management system
public class StudentDatabaseSystem45 {
    public static void main(String[] args) {
        // Create an instance of StudentDatabase
        StudentDatabase45 studentDatabase = new StudentDatabase45();

        // Add new students to the database
        studentDatabase.addStudent(new Student45("S001", "Alice Johnson", "Computer Science"));
        studentDatabase.addStudent(new Student45("S002", "Bob Smith", "Mathematics"));
        studentDatabase.addStudent(new Student45("S003", "Charlie Brown", "Physics"));

        // Demonstrate removing a student
        studentDatabase.removeStudent("S002");

        // Demonstrate searching for students by ID and name
        studentDatabase.searchById("S001");
        studentDatabase.searchByName("Charlie Brown");

        // Display all student details
        studentDatabase.displayAllStudents();
    }
}
