import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
abstract class Employee{
    protected String name;
    protected String employeeId;

    public Employee(String name , String employeeId){
        this.name = name;
        this.employeeId = employeeId;

    }
    public abstract double calculatesalory();
    public abstract String evaluateperformance();

    public String getname(){
        return name;
    }
    public String getemployeeId(){
        return employeeId;
    }

}

class Fulltime extends  Employee{
    private double monthlysalary;
    private double performancebonus;
    public Fulltime(String name , String employeeId , double monthlysalary , double performancebonus){
        super(name , employeeId);
        this.monthlysalary = monthlysalary;
        this.performancebonus = performancebonus;

    }
    @Override
    public double calculatesalory(){
        return monthlysalary + performancebonus;
    }

    @Override
    public String evaluateperformance(){
        if (performancebonus > 1000) {
            return "Excellent";
        } else if (performancebonus > 500) {
            return "Good";
        } else {
            return "Needs Improvement";
        }


    }
}

class Partime extends Employee{
    private double hourlyRate;
    private int hoursWorked;

    public Partime(String name, String employeeId, double hourlyRate, int hoursWorked) {
        super(name, employeeId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatesalory() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String evaluateperformance() {
        return "Performance evaluation not applicable for part-time employees.";
    }
}



public class ps15 {
    private static List<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Register Employee");
            System.out.println("2. Calculate Salary");
            System.out.println("3. Evaluate Performance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    registerEmployee();
                    break;
                case 2:
                    calculateSalary();
                    break;
                case 3:
                    evaluatePerformance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void registerEmployee() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee ID: ");
        String employeeID = scanner.nextLine();

        System.out.println("1. Full-Time Employee");
        System.out.println("2. Part-Time Employee");
        System.out.print("Select employee type: ");
        int type = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (type) {
            case 1:
                System.out.print("Enter monthly salary: ");
                double monthlySalary = scanner.nextDouble();
                System.out.print("Enter performance bonus: ");
                double performanceBonus = scanner.nextDouble();
                employees.add(new Fulltime(name, employeeID, monthlySalary, performanceBonus));
                break;
            case 2:
                System.out.print("Enter hourly rate: ");
                double hourlyRate = scanner.nextDouble();
                System.out.print("Enter hours worked: ");
                int hoursWorked = scanner.nextInt();
                employees.add(new Partime(name, employeeID, hourlyRate, hoursWorked));
                break;
            default:
                System.out.println("Invalid type selected.");
        }
        System.out.println("Employee registered successfully.");
    }

    private static void calculateSalary() {
        System.out.print("Enter employee ID: ");
        String employeeId = scanner.nextLine();
        for (Employee emp : employees) {
            if (emp.getemployeeId().equals(employeeId)) {
                System.out.println("Salary for " + emp.getname() + ": " + emp.calculatesalory());
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    private static void evaluatePerformance() {
        System.out.print("Enter employee ID: ");
        String employeeId = scanner.nextLine();
        for (Employee emp : employees) {
            if (emp.getemployeeId().equals(employeeId)) {
                System.out.println("Performance for " + emp.getname() + ": " + emp.evaluateperformance());
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}
