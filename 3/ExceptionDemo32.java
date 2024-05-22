package ppss;

public class ExceptionDemo32 {
    public static void main(String[] args) {
        // Handle NegativeArraySizeException
        try {
            int size = -5;
            int[] array = new int[size];
        } catch (NegativeArraySizeException e) {
            System.out.println("Exception caught: " + e);
        }

        // Handle ArithmeticException
        try {
            int numerator = 10;
            int denominator = 0;
            int result = numerator / denominator;
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e);
        }
    }
}
