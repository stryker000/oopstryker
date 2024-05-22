package ppss;

class Vehicle4 {
    private String make;
    private String model;
    private int year;

    // Constructor
    public Vehicle4(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getter for make
    public String getMake() {
        return make;
    }

    // Setter for make
    public void setMake(String make) {
        this.make = make;
    }

    // Getter for model
    public String getModel() {
        return model;
    }

    // Setter for model
    public void setModel(String model) {
        this.model = model;
    }

    // Getter for year
    public int getYear() {
        return year;
    }

    // Setter for year
    public void setYear(int year) {
        this.year = year;
    }

    // toString method to display vehicle details
    @Override
    public String toString() {
        return "Vehicle [make=" + make + ", model=" + model + ", year=" + year + "]";
    }
}

class Car4 extends Vehicle4 {
    private int numberOfDoors;

    // Constructor
    public Car4(String make, String model, int year, int numberOfDoors) {
        super(make, model, year); // Call the constructor of the superclass (Vehicle)
        this.numberOfDoors = numberOfDoors;
    }

    // Getter for numberOfDoors
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    // Setter for numberOfDoors
    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    // toString method to display car details
    @Override
    public String toString() {
        return "Car [make=" + getMake() + ", model=" + getModel() + ", year=" + getYear() + ", numberOfDoors=" + numberOfDoors + "]";
    }
}

public class Main41 {
    public static void main(String[] args) {
        // Create an instance of Vehicle
        Vehicle4 vehicle = new Vehicle4("Toyota", "Camry", 2019);
        System.out.println(vehicle.toString());

        // Create an instance of Car
        Car4 car = new Car4("Honda", "Civic", 2020, 4);
        System.out.println(car.toString());

        // Access and modify properties using getter and setter methods
        car.setMake("Ford");
        car.setModel("Focus");
        car.setYear(2021);
        car.setNumberOfDoors(5);

        System.out.println("Updated Car Details:");
        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Number of Doors: " + car.getNumberOfDoors());
    }
}
