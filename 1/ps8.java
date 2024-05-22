import java.util.Arrays;
import java.util.Scanner;

public class ps8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        scanner.close();

        performOperations(array);
    }

    public static void performOperations(int[] array) {
       
        int[] initializedArray = initializeArray(array.clone());
        System.out.println("Initialized array: " + Arrays.toString(initializedArray));

        int sum = findSum(array);
        System.out.println("Sum of elements: " + sum);

        int max = findMax(array);
        System.out.println("Maximum element: " + max);

        int min = findMin(array);
        System.out.println("Minimum element: " + min);

        sortArray(array);
        System.out.println("Sorted array: " + Arrays.toString(array));

        reverseArray(array);
        System.out.println("Reversed array: " + Arrays.toString(array));
    }

    public static int[] initializeArray(int[] elements) {
        return elements.clone();
    }

    public static int findSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void sortArray(int[] arr) {
        Arrays.sort(arr);
    }

    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
