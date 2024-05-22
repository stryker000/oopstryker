import java.util.Scanner;

public class ps11d {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number1:- ");
        int n1 = sc.nextInt();
        if (n1 % 2 == 0){
            System.out.println("The given number " + n1 + " is an even number");
        }
        else{
            System.out.println("The given number " + n1 + " is an odd number");
        }


    }
    
}
