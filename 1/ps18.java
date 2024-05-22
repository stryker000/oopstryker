import java.util.*;

public class ps18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string of your choice: ");
        String str = sc.nextLine();

        int length = longestSubstring(str);

        System.out.println("The length of the longest possible substring is: " + length);

        sc.close();
    }

    public static int longestSubstring(String input) {
        int n = input.length();
        Set<Character> set = new HashSet<>();
        int maxln = 0, i = 0, j = 0;

        while (i < n && j < n) {
            if (!set.contains(input.charAt(j))) {
                set.add(input.charAt(j));
                j++;
                maxln = Math.max(maxln, j - i); // Correct calculation
            } else {
                set.remove(input.charAt(i));
                i++;
            }
        }
        return maxln;
    }
}
