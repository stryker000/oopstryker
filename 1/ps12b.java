import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class ps12b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of ArrayList:- ");
        int size = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter " + size + " elements for the ArrrayList");

        for(int i = 0 ; i<size ; i++){
            list.add(sc.nextInt());

        }
        System.out.println("Elements are:- " + list);

        //1
        System.out.print("Enter the element to chk if it is present in list or not:- ");
        int chk = sc.nextInt();
        boolean exist = list.contains(chk);
        System.out.println("Element " + chk + " exists =  " + exist);

        //2
        System.out.print("Enter the index at which you want to add the element ");
        int ind = sc.nextInt();
        System.out.print("Enter the elelment you want to add ");
        int ele = sc.nextInt();

        if(ind >= 0 && ind<list.size()){
            list.add(ind, ele);
        }
        else{
            System.out.println("Dear user pls enter the valid index ");
        }
        System.out.println("List after adding the element is :- " + list);

        //3
        System.out.println("Enter the index from where you want to remove element:- ");
        int ind2 = sc.nextInt();
        if(ind2 >= 0 && ind2<list.size()){
            list.remove(ind2);
        }
        else {
            System.out.println("Please enter the valid syntax!");
        }
        System.out.println("List after removing element from index " + ind2 + " is " + list);

        //4
        System.out.println("Now let us see the sorted list:-");
        Collections.sort(list);
        System.out.println(list);

        //5

        System.out.println("Now let us see the reversed lsit: - ");
        Collections.reverse(list);
        System.out.println(list);

        //6

        System.out.print("Enter the element to find its first and last occurrence: ");
        int elementToFind = sc.nextInt();
        int firstOccurrence = list.indexOf(elementToFind);
        int lastOccurrence = list.lastIndexOf(elementToFind);
        if (firstOccurrence != -1 && lastOccurrence != -1) {
            System.out.println("First occurrence: " + firstOccurrence);
            System.out.println("Last occurrence: " + lastOccurrence);
        } else {
            System.out.println("Element not found.");
        }

        //7

        System.out.print("Enter the size of another array list so as to compare:- ");
        int size2 = sc.nextInt();
        ArrayList<Integer> list2 = new ArrayList<>();
        System.out.println("Enter " + size2 + " elements");
        for(int i=0 ; i<size2 ; i++){
            list2.add(sc.nextInt());

        }
        boolean eq = list.equals(list2);
        System.out.println("Are the two list equal to each other ? : " + eq);





    }
    
    
}
