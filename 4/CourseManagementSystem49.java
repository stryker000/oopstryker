package ppss;

//Base class for all courses
class Course {
 protected String title;
 protected String instructor;
 protected int duration; // Duration in hours
 protected double enrollmentFee;

 // Constructor to initialize common attributes
 public Course(String title, String instructor, int duration, double enrollmentFee) {
     this.title = title;
     this.instructor = instructor;
     this.duration = duration;
     this.enrollmentFee = enrollmentFee;
 }

 // Method to display course details
 public void displayCourseDetails() {
     System.out.println("Course Title: " + title);
     System.out.println("Instructor: " + instructor);
     System.out.println("Duration: " + duration + " hours");
     System.out.println("Enrollment Fee: $" + enrollmentFee);
 }
}

//Derived class for Programming courses
class ProgrammingCourse extends Course {
 private String programmingLanguage;
 private boolean includesProject;

 // Constructor to initialize specific attributes along with common attributes
 public ProgrammingCourse(String title, String instructor, int duration, double enrollmentFee, String programmingLanguage, boolean includesProject) {
     super(title, instructor, duration, enrollmentFee);
     this.programmingLanguage = programmingLanguage;
     this.includesProject = includesProject;
 }

 // Override to display programming course details
 @Override
 public void displayCourseDetails() {
     super.displayCourseDetails();
     System.out.println("Programming Language: " + programmingLanguage);
     System.out.println("Includes Project: " + (includesProject ? "Yes" : "No"));
 }
}

//Derived class for Mathematics courses
class MathematicsCourse extends Course {
 private String difficultyLevel;

 // Constructor to initialize specific attributes along with common attributes
 public MathematicsCourse(String title, String instructor, int duration, double enrollmentFee, String difficultyLevel) {
     super(title, instructor, duration, enrollmentFee);
     this.difficultyLevel = difficultyLevel;
 }

 // Override to display mathematics course details
 @Override
 public void displayCourseDetails() {
     super.displayCourseDetails();
     System.out.println("Difficulty Level: " + difficultyLevel);
 }
}

//Derived class for Literature courses
class LiteratureCourse extends Course {
 private String genre;

 // Constructor to initialize specific attributes along with common attributes
 public LiteratureCourse(String title, String instructor, int duration, double enrollmentFee, String genre) {
     super(title, instructor, duration, enrollmentFee);
     this.genre = genre;
 }

 // Override to display literature course details
 @Override
 public void displayCourseDetails() {
     super.displayCourseDetails();
     System.out.println("Genre: " + genre);
 }
}

//Main class to test the course management system
public class CourseManagementSystem49 {
 public static void main(String[] args) {
     // Create instances of different course types
     ProgrammingCourse javaCourse = new ProgrammingCourse("Java Programming", "John Doe", 40, 299.99, "Java", true);
     MathematicsCourse algebraCourse = new MathematicsCourse("Algebra 101", "Jane Smith", 30, 199.99, "Beginner");
     LiteratureCourse poetryCourse = new LiteratureCourse("Poetry and Prose", "Emily Johnson", 20, 149.99, "Poetry");

     // Display details of each course
     System.out.println("Programming Course Details:");
     javaCourse.displayCourseDetails();
     System.out.println();

     System.out.println("Mathematics Course Details:");
     algebraCourse.displayCourseDetails();
     System.out.println();

     System.out.println("Literature Course Details:");
     poetryCourse.displayCourseDetails();
     System.out.println();
 }
}
