import java.util.*;

public class ps14 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        // Create a set to store the unique elements from nums1
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        // Create a list to store the common elements
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
                set1.remove(num); // Remove the element to avoid duplicates
            }
        }

        int[] intersectionArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersectionArray[i] = result.get(i);
        }

        return intersectionArray;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 1 };
        int[] nums2 = { 2, 3 };

        int[] intersectionResult = intersection(nums1, nums2);

        System.out.print("Intersection: ");
        for (int num : intersectionResult) {
            System.out.print(num + " ");
        }
    }
}
