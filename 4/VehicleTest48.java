package ppss;

class Vehicle48 {
 private String make;
 private String model;
 private int year;
 private int mileage;

 // Constructor to initialize Vehicle attributes with validation
 public Vehicle48(String make, String model, int year, int mileage) {
     // Validate and assign make
     if (make == null || make.trim().isEmpty()) {
         throw new IllegalArgumentException("Make cannot be null or empty.");
     }
     this.make = make;

     // Validate and assign model
     if (model == null || model.trim().isEmpty()) {
         throw new IllegalArgumentException("Model cannot be null or empty.");
     }
     this.model = model;

     // Validate and assign year
     int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
     if (year < 1886 || year > currentYear) { // The first car was made in 1886
         throw new IllegalArgumentException("Year must be between 1886 and the current year.");
     }
     this.year = year;

     // Validate and assign mileage
     if (mileage < 0) {
         throw new IllegalArgumentException("Mileage cannot be negative.");
     }
     this.mileage = mileage;
 }

 // Method to display vehicle details
 @Override
 public String toString() {
     return "Vehicle [Make: " + make + ", Model: " + model + ", Year: " + year + ", Mileage: " + mileage + "]";
 }
}

//Main class to test the Vehicle constructor
public class VehicleTest48 {
 public static void main(String[] args) {
     // Create vehicle objects with various parameters and test validation

     try {
         Vehicle48 car1 = new Vehicle48("Toyota", "Camry", 2020, 15000);
         System.out.println(car1);
     } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
     }

     try {
         Vehicle48 car2 = new Vehicle48("Honda", "Civic", 2018, 30000);
         System.out.println(car2);
     } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
     }

     try {
         Vehicle48 car3 = new Vehicle48("Ford", "Mustang", 2023, 5000);
         System.out.println(car3);
     } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
     }

     // Test with invalid year
     try {
         Vehicle48 car4 = new Vehicle48("Chevrolet", "Impala", 1885, 20000);
         System.out.println(car4);
     } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
     }

     // Test with negative mileage
     try {
         Vehicle48 car5 = new Vehicle48("Tesla", "Model S", 2021, -100);
         System.out.println(car5);
     } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
     }

     // Test with empty make
     try {
         Vehicle48 car6 = new Vehicle48("", "Accord", 2019, 25000);
         System.out.println(car6);
     } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
     }

     // Test with empty model
     try {
         Vehicle48 car7 = new Vehicle48("Nissan", "", 2017, 40000);
         System.out.println(car7);
     } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
     }
 }
}
