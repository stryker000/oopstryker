import java.util.*;

public class ps13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        System.out.print("Enter the minimum value: ");
        int minValue = scanner.nextInt();
        System.out.print("Enter the maximum value: ");
        int maxValue = scanner.nextInt();

        int[] array = generateRandomArray(size, minValue, maxValue);
        System.out.println("Generated array: " + Arrays.toString(array));

        System.out.print("Enter the number of positions to rotate the array: ");
        int positions = scanner.nextInt();
        int[] rotatedArray = rotateArray(array, positions);
        System.out.println("Array after rotation: " + Arrays.toString(rotatedArray));

        int[] uniqueArray = removeDuplicates(array);
        System.out.println("Array after removing duplicates: " + Arrays.toString(uniqueArray));

        int[] rearrangedArray = rearrangeEvenOdd(array);
        System.out.println("Array after rearranging even and odd numbers: " + Arrays.toString(rearrangedArray));

        scanner.close();
    }

    public static int[] generateRandomArray(int size, int minValue, int maxValue) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt((maxValue - minValue) + 1) + minValue;
        }
        return array;
    }

    public static int[] rotateArray(int[] array, int positions) {
        int length = array.length;
        positions = positions % length;
        int[] rotatedArray = new int[length];

        for (int i = 0; i < length; i++) {
            rotatedArray[(i + positions) % length] = array[i];
        }
        return rotatedArray;
    }

    public static int[] removeDuplicates(int[] array) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int value : array) {
            set.add(value);
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (int value : set) {
            result[index++] = value;
        }
        return result;
    }

    public static int[] rearrangeEvenOdd(int[] array) {
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();
        for (int value : array) {
            if (value % 2 == 0) {
                evenList.add(value);
            } else {
                oddList.add(value);
            }
        }
        evenList.addAll(oddList);
        int[] result = new int[evenList.size()];
        for (int i = 0; i < evenList.size(); i++) {
            result[i] = evenList.get(i);
        }
        return result;
    }
}
