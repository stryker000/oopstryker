import java.util.*;
class Calci extends Thread {
    private double n1;
    private double n2;
    private String oprn;

    public Calci(double n1, double n2, String oprn) {
        this.n1 = n1;
        this.n2 = n2;
        this.oprn = oprn;
    }

    @Override
    public void run() {
        switch (oprn) {
            case "addition":
                System.out.println("Addition of two numbers is: " + (n1 + n2));
                break;
            case "subtraction":
                System.out.println("Subtraction of two numbers is: " + (n1 - n2));
                break;
            case "multiply":
                System.out.println("Multiplication of two numbers is: " + (n1 * n2));
                break;
            case "division":
                if (n2 == 0) {
                    System.out.println("Error: Division by zero");
                } else {
                    System.out.println("Division of two numbers is: " + (n1 / n2));
                }
                break;
            default:
                System.out.println("Please enter a valid operator.");
        }
    }
}

public class ps17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double n1 = 0, n2 = 0;
        boolean validin = false;
        while (!validin) {
            try {
                System.out.print("Enter number1 for thread: ");
                n1 = sc.nextDouble();
                System.out.print("Enter number2 for thread: ");
                n2 = sc.nextDouble();
                sc.nextLine();  // Consume the newline left-over
                validin = true;
            } catch (InputMismatchException e) {
                System.out.println("Dear user, please enter valid numerical input.");
                sc.next(); // Clear the invalid input
            }
        }

        System.out.print("Choose an operation of your choice: ");
        String oprn = sc.nextLine().toLowerCase();

        Calci operationThread = null;
        
        switch (oprn) {
            case "addition":
                operationThread = new Calci(n1, n2, "addition");
                break;
            case "subtraction":
                operationThread = new Calci(n1, n2, "subtraction");
                break;
            case "multiply":
                operationThread = new Calci(n1, n2, "multiply");
                break;
            case "division":
                operationThread = new Calci(n1, n2, "division");
                break;
            default:
                System.out.println("Invalid operation. Please choose from addition, subtraction, multiply, division.");
                sc.close();
                return;
        }

        if (operationThread != null) {
            operationThread.start();
            try {
                operationThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        sc.close();
    }
}
