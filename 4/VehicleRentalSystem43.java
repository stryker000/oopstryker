package ppss;

//Define the Rentable interface with methods for renting, returning, and calculating rental cost
interface Rentable {
 void rent();
 void returnVehicle();
 double calculateRentalCost(int days);
}

//Implement the Rentable interface in the Carr class
class Carr implements Rentable {
 private String make;
 private String model;
 private boolean isRented;
 private double dailyRate;

 // Constructor to initialize Carr attributes
 public Carr(String make, String model, double dailyRate) {
     this.make = make;
     this.model = model;
     this.dailyRate = dailyRate;
     this.isRented = false;
 }

 @Override
 public void rent() {
     if (!isRented) {
         isRented = true;
         System.out.println("Carr rented: " + make + " " + model);
     } else {
         System.out.println("Carr is already rented.");
     }
 }

 @Override
 public void returnVehicle() {
     if (isRented) {
         isRented = false;
         System.out.println("Carr returned: " + make + " " + model);
     } else {
         System.out.println("Carr was not rented.");
     }
 }

 @Override
 public double calculateRentalCost(int days) {
     return dailyRate * days;
 }
}

//Implement the Rentable interface in the Motorcycle class
class Motorcycle implements Rentable {
 private String make;
 private String model;
 private boolean isRented;
 private double dailyRate;

 // Constructor to initialize Motorcycle attributes
 public Motorcycle(String make, String model, double dailyRate) {
     this.make = make;
     this.model = model;
     this.dailyRate = dailyRate;
     this.isRented = false;
 }

 @Override
 public void rent() {
     if (!isRented) {
         isRented = true;
         System.out.println("Motorcycle rented: " + make + " " + model);
     } else {
         System.out.println("Motorcycle is already rented.");
     }
 }

 @Override
 public void returnVehicle() {
     if (isRented) {
         isRented = false;
         System.out.println("Motorcycle returned: " + make + " " + model);
     } else {
         System.out.println("Motorcycle was not rented.");
     }
 }

 @Override
 public double calculateRentalCost(int days) {
     return dailyRate * days;
 }
}

//Implement the Rentable interface in the Bicycle class
class Bicycle implements Rentable {
 private String type;
 private boolean isRented;
 private double dailyRate;

 // Constructor to initialize Bicycle attributes
 public Bicycle(String type, double dailyRate) {
     this.type = type;
     this.dailyRate = dailyRate;
     this.isRented = false;
 }

 @Override
 public void rent() {
     if (!isRented) {
         isRented = true;
         System.out.println("Bicycle rented: " + type);
     } else {
         System.out.println("Bicycle is already rented.");
     }
 }

 @Override
 public void returnVehicle() {
     if (isRented) {
         isRented = false;
         System.out.println("Bicycle returned: " + type);
     } else {
         System.out.println("Bicycle was not rented.");
     }
 }

 @Override
 public double calculateRentalCost(int days) {
     return dailyRate * days;
 }
}

//RentalManager class to handle the renting and returning of vehicles
class RentalManager {
 private Rentable[] vehicles;

 // Constructor to initialize RentalManager with a list of vehicles
 public RentalManager(Rentable[] vehicles) {
     this.vehicles = vehicles;
 }

 // Method to rent a vehicle by index
 public void rentVehicle(int index) {
     if (index >= 0 && index < vehicles.length) {
         vehicles[index].rent();
     } else {
         System.out.println("Invalid vehicle index.");
     }
 }

 // Method to return a vehicle by index
 public void returnVehicle(int index) {
     if (index >= 0 && index < vehicles.length) {
         vehicles[index].returnVehicle();
     } else {
         System.out.println("Invalid vehicle index.");
     }
 }

 // Method to calculate the rental cost for a vehicle by index and number of days
 public void calculateCost(int index, int days) {
     if (index >= 0 && index < vehicles.length) {
         double cost = vehicles[index].calculateRentalCost(days);
         System.out.println("Rental cost for " + days + " days: $" + cost);
     } else {
         System.out.println("Invalid vehicle index.");
     }
 }
}

//Main class to demonstrate the vehicle rental system
public class VehicleRentalSystem43 {
 public static void main(String[] args) {
     // Create instances of vehicles
     Carr Carr = new Carr("Toyota", "Camry", 50.0);
     Motorcycle motorcycle = new Motorcycle("Honda", "CBR500R", 30.0);
     Bicycle bicycle = new Bicycle("Mountain", 15.0);

     // Create an array of Rentable vehicles
     Rentable[] vehicles = {Carr, motorcycle, bicycle};

     // Create an instance of RentalManager with the vehicles array
     RentalManager rentalManager = new RentalManager(vehicles);

     // Demonstrate renting, returning, and calculating cost
     rentalManager.rentVehicle(0);  // Rent Carr
     rentalManager.calculateCost(0, 3);  // Calculate cost for 3 days for Carr
     rentalManager.returnVehicle(0);  // Return Carr

     rentalManager.rentVehicle(1);  // Rent motorcycle
     rentalManager.calculateCost(1, 2);  // Calculate cost for 2 days for motorcycle
     rentalManager.returnVehicle(1);  // Return motorcycle

     rentalManager.rentVehicle(2);  // Rent bicycle
     rentalManager.calculateCost(2, 5);  // Calculate cost for 5 days for bicycle
     rentalManager.returnVehicle(2);  // Return bicycle
 }
}
