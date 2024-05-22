import java.util.Arrays;
import java.util.Scanner;

public class ps11b {

    public static void main(String[] args) {
        
    
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the two strings of your choice ");
    System.out.println("Enter the string 1: ");
    String st1 = sc.nextLine();
    System.out.println("Enter the string 2: ");
    String st2 = sc.nextLine();
    if(isAnagram(st1, st2)){
        System.out.println("The given two strings are anagram ");
    }
    else{
        System.out.println("The given two strings are not anagrams");
    }

}

public static boolean isAnagram(String st1, String st2){
    if(st1.length() != st2.length()){
        return false;
    }
    else{
        char[] ch1 = st1.toCharArray();
        char[] ch2 = st2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }
}
}
