import java.util.HashSet;
import java.util.Scanner;


public class ps10{
    public static void main(String[] args) {
        System.out.println("Enter the string of your choice: ");

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println("The entered string is:-" + str);

        HashSet<String> wordset = new HashSet<>();

        String[] words = str.split("\\s+");
        for(String word : words){
            wordset.add(word);
        }
        int cnt = wordset.size();

        System.out.println("No of Unique words are - " + cnt);
        System.out.println("Words of HAshset are  - " + wordset);

        sc.close();
    }

}