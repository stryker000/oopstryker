import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vehicle {
    private static int nextId = 1;
    protected int id;
    protected String brand;
    protected double rentalRate;

    public Vehicle(String brand, double rentalRate) {
        this.id = nextId++;
        this.brand = brand;
        this.rentalRate = rentalRate;
    }

    public void displayDetails() {
        System.out.println("Vehicle ID: " + id);
        System.out.println("Brand: " + brand);
        System.out.println("Rental Rate: $" + rentalRate + " per hour");
    }

    public double calculateRentalCost(int hours) {
        return rentalRate * hours;
    }
}

class Car extends Vehicle {
    final private int numSeats;

    public Car(String brand, double rentalRate, int numSeats) {
        super(brand, rentalRate);
        this.numSeats = numSeats;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Seats: " + numSeats);
    }
}

class Bicycle extends Vehicle {
    final private String type;

    public Bicycle(String brand, double rentalRate, String type) {
        super(brand, rentalRate);
        this.type = type;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Type: " + type);
    }
}

public class ps24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();

        boolean continueAdding = true;
        while (continueAdding) {
            System.out.println("Enter vehicle type (car/bicycle): ");
            String vehicleType = scanner.nextLine().trim().toLowerCase();

            switch (vehicleType) {
                case "car":
                    System.out.println("Enter brand: ");
                    String carBrand = scanner.nextLine().trim();

                    System.out.println("Enter rental rate per hour: ");
                    double carRentalRate = Double.parseDouble(scanner.nextLine());

                    System.out.println("Enter number of seats: ");
                    int numSeats = Integer.parseInt(scanner.nextLine());

                    vehicles.add(new Car(carBrand, carRentalRate, numSeats));
                    break;
                case "bicycle":
                    System.out.println("Enter brand: ");
                    String bikeBrand = scanner.nextLine().trim();

                    System.out.println("Enter rental rate per hour: ");
                    double bikeRentalRate = Double.parseDouble(scanner.nextLine());

                    System.out.println("Enter type: ");
                    String bikeType = scanner.nextLine().trim();

                    vehicles.add(new Bicycle(bikeBrand, bikeRentalRate, bikeType));
                    break;
                default:
                    System.out.println("Invalid vehicle type. Please enter 'car' or 'bicycle'.");
            }

            System.out.println("Do you want to add another vehicle? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            continueAdding = response.equals("yes");
        }

        System.out.println("Available Vehicles:");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
            System.out.println();
        }

        System.out.println("Enter the ID of the vehicle you want to rent: ");
        int vehicleIdToRent = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter the number of hours you want to rent the vehicle for: ");
        int hoursToRent = Integer.parseInt(scanner.nextLine());

        boolean vehicleFound = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.id == vehicleIdToRent) {
                double totalCost = vehicle.calculateRentalCost(hoursToRent);
                System.out.println("Rental Details:");
                vehicle.displayDetails();
                System.out.println("Rented for " + hoursToRent + " hours");
                System.out.println("Total Cost: $" + totalCost);
                vehicleFound = true;
                break;
            }
        }

        if (!vehicleFound) {
            System.out.println("Vehicle with ID " + vehicleIdToRent + " not found.");
        }

        scanner.close();
    }
}
