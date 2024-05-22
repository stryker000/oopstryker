// Interface for shapes that can be drawn
interface Drawable {
    void draw();
}

// Interface for shapes that can be resized
interface Resizable {
    void resize(double factor);
}

// Circle class implementing both Drawable and Resizable interfaces
class Circle implements Drawable, Resizable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }

    @Override
    public void resize(double factor) {
        radius *= factor;
        System.out.println("Resizing Circle with factor: " + factor);
        System.out.println("After resizing radius is " + radius);
    }
}

// Rectangle class implementing only the Drawable interface
class Rectangle implements Drawable {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

public class ps7 {
    public static void main(String[] args) {
        // Creating a Circle object
        Circle circle = new Circle(5);
        circle.draw();
        circle.resize(1.5);

        // Creating a Rectangle object
        Rectangle rectangle = new Rectangle(10, 20);
        rectangle.draw();
    }
}
