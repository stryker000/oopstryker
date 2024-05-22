package ppss;

import java.util.ArrayList;
import java.util.Scanner;

public class IntegerListManipulator310 {
    // Main method to interact with the user
    public static void main(String[] args) {
        ArrayList<Integer> integerList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Integer List Manipulator ===");
            System.out.println("1. Add an integer to the end of the list");
            System.out.println("2. Insert an integer at a specified index in the list");
            System.out.println("3. Remove an integer from the list based on its value");
            System.out.println("4. Remove an integer at a specified index in the list");
            System.out.println("5. Search for the index of a given integer in the list");
            System.out.println("6. Display all integers in the list");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add an integer to the end of the list
                    System.out.print("Enter the integer to add: ");
                    int addValue = scanner.nextInt();
                    integerList.add(addValue);
                    System.out.println(addValue + " added to the list.");
                    break;
                case 2:
                    // Insert an integer at a specified index in the list
                    System.out.print("Enter the index to insert at: ");
                    int insertIndex = scanner.nextInt();
                    System.out.print("Enter the integer to insert: ");
                    int insertValue = scanner.nextInt();
                    if (insertIndex >= 0 && insertIndex <= integerList.size()) {
                        integerList.add(insertIndex, insertValue);
                        System.out.println(insertValue + " inserted at index " + insertIndex);
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 3:
                    // Remove an integer from the list based on its value
                    System.out.print("Enter the integer to remove: ");
                    int removeValue = scanner.nextInt();
                    if (integerList.remove(Integer.valueOf(removeValue))) {
                        System.out.println(removeValue + " removed from the list.");
                    } else {
                        System.out.println(removeValue + " not found in the list.");
                    }
                    break;
                case 4:
                    // Remove an integer at a specified index in the list
                    System.out.print("Enter the index to remove: ");
                    int removeIndex = scanner.nextInt();
                    if (removeIndex >= 0 && removeIndex < integerList.size()) {
                        int removedValue = integerList.remove(removeIndex);
                        System.out.println(removedValue + " removed from index " + removeIndex);
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 5:
                    // Search for the index of a given integer in the list
                    System.out.print("Enter the integer to search for: ");
                    int searchValue = scanner.nextInt();
                    int index = integerList.indexOf(searchValue);
                    if (index != -1) {
                        System.out.println(searchValue + " found at index " + index);
                    } else {
                        System.out.println(searchValue + " not found in the list.");
                    }
                    break;
                case 6:
                    // Display all integers in the list
                    System.out.println("Current list: " + integerList);
                    break;
                case 7:
                    // Exit the program
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                default:
                    // Handle invalid choices
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
