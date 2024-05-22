import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;


public class ps12a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,1,3,3,5,5,2,1));
       
        System.out.println("Orignal members of list are :- " + arr);

        ArrayList<Integer> unique = removeduplicate(arr);
        System.out.println("Unique members of List are:- " + unique);
    }

    public static ArrayList<Integer> removeduplicate(ArrayList<Integer> list){
        Set<Integer> set = new LinkedHashSet<>(list);
        return new ArrayList<>(set);

    }
}
