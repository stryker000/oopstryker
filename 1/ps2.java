class Employee {
    private String name;
    private int employeeId;
    private double hourlyRate;

    public Employee(String name, int employeeId, double hourlyRate) {
        this.name = name;
        this.employeeId = employeeId;
        this.hourlyRate = hourlyRate;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}

class FullTimeEmployee extends Employee {
    private double salary;
    private String benefits;

    public FullTimeEmployee(String name, int employeeId, double hourlyRate, double salary, String benefits) {
        super(name, employeeId, hourlyRate);
        this.salary = salary;
        this.benefits = benefits;
    }

    public double getSalary() {
        return salary;
    }

    public String getBenefits() {
        return benefits;
    }

    public double calculateMonthlySalary() {
        return salary;
    }
}

class PartTimeEmployee extends Employee {
    private double hoursWorked;
    private double overtimeRate;

    public PartTimeEmployee(String name, int employeeId, double hourlyRate, double hoursWorked, double overtimeRate) {
        super(name, employeeId, hourlyRate);
        this.hoursWorked = hoursWorked;
        this.overtimeRate = overtimeRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getOvertimeRate() {
        return overtimeRate;
    }

    public double calculateMonthlySalary() {
        double regularPay = hoursWorked * getHourlyRate();
        double overtimePay = 0;
        if (hoursWorked > 40) {
            overtimePay = (hoursWorked - 40) * overtimeRate * getHourlyRate();
        }
        return regularPay + overtimePay;
    }
}

public class ps2 {
    public static void main(String[] args) {
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("John Doe", 101, 25.0, 5000.0, "Health insurance");
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Jane Smith", 102, 20.0, 45.0, 1.5);

        System.out.println("Full-Time Employee:");
        System.out.println("Name: " + fullTimeEmployee.getName());
        System.out.println("Employee ID: " + fullTimeEmployee.getEmployeeId());
        System.out.println("Monthly Salary: $" + fullTimeEmployee.calculateMonthlySalary());
        System.out.println("Benefits: " + fullTimeEmployee.getBenefits());

        System.out.println("\nPart-Time Employee:");
        System.out.println("Name: " + partTimeEmployee.getName());
        System.out.println("Employee ID: " + partTimeEmployee.getEmployeeId());
        System.out.println("Monthly Salary: $" + partTimeEmployee.calculateMonthlySalary());
    }
}
