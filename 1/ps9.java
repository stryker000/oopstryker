import java.util.Scanner;

public class ps9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        
        System.out.println("Enter the initial string: ");
        str = scanner.nextLine();
        
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("A. Concatenate two strings");
            System.out.println("B. Find the length of a string");
            System.out.println("C. Convert a string to uppercase");
            System.out.println("D. Convert a string to lowercase");
            System.out.println("E. Check if a string contains a specific substring");
            System.out.println("F. Replace a substring with another substring");
            System.out.println("G. Exit");
            char choice = scanner.next().charAt(0);
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 'A':
                    System.out.println("Enter the string to concatenate: ");
                    String toConcatenate = scanner.nextLine();
                    str = str.concat(toConcatenate);
                    System.out.println("Resulting string: " + str);
                    break;
                case 'B':
                    System.out.println("Length of the string: " + str.length());
                    break;
                case 'C':
                    str = str.toUpperCase();
                    System.out.println("String in uppercase: " + str);
                    break;
                case 'D':
                    str = str.toLowerCase();
                    System.out.println("String in lowercase: " + str);
                    break;
                case 'E':
                    System.out.println("Enter the substring to check: ");
                    String substring = scanner.nextLine();
                    if (str.contains(substring)) {
                        System.out.println("The string contains the substring.");
                    } else {
                        System.out.println("The string does not contain the substring.");
                    }
                    break;
                case 'F':
                    System.out.println("Enter the substring to replace: ");
                    String oldSubstring = scanner.nextLine();
                    System.out.println("Enter the new substring: ");
                    String newSubstring = scanner.nextLine();
                    str = str.replace(oldSubstring, newSubstring);
                    System.out.println("Resulting string: " + str);
                    break;
                case 'G':
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
