import java.util.Scanner;

public class ps11a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        if (isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
        
        scanner.close();
    }
    
    public static boolean isArmstrong(int number) {
        // Calculate the number of digits
        int numDigits = String.valueOf(number).length();
        
        // Calculate the sum of the digits raised to the power of numDigits
        int sum = 0;
        int temp = number;
        while (temp != 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, numDigits);
            temp /= 10;
        }
        
        // Check if the sum is equal to the original number
        return sum == number;
    }
}
