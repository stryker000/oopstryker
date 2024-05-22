package ppss;
abstract class Shape2 {
    // Abstract methods for area and perimeter
    public abstract double area();
    public abstract double perimeter();
}

class Rectangle2 extends Shape2 {
    private double length;
    private double width;

    // Constructor to initialize length and width
    public Rectangle2(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Implementation of area method
    @Override
    public double area() {
        return length * width;
    }

    // Implementation of perimeter method
    @Override
    public double perimeter() {
        return 2 * (length + width);
    }

    // Method to display the details of the rectangle
    public void display() {
        System.out.println("Rectangle:");
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Area: " + area());
        System.out.println("Perimeter: " + perimeter());
    }
}

class Triangle2 extends Shape2 {
    private double sideA;
    private double sideB;
    private double sideC;

    // Constructor to initialize the sides of the triangle
    public Triangle2(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    // Implementation of area method using Heron's formula
    @Override
    public double area() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    // Implementation of perimeter method
    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
    }

    // Method to display the details of the triangle
    public void display() {
        System.out.println("Triangle:");
        System.out.println("Side A: " + sideA);
        System.out.println("Side B: " + sideB);
        System.out.println("Side C: " + sideC);
        System.out.println("Area: " + area());
        System.out.println("Perimeter: " + perimeter());
    }
}

public class Main34 {
    public static void main(String[] args) {
        // Create a rectangle with length 5 and width 3
        Rectangle2 rectangle = new Rectangle2(5, 3);
        rectangle.display();

        // Create a triangle with sides 3, 4, and 5
        Triangle2 triangle = new Triangle2(3, 4, 5);
        triangle.display();
    }
}

