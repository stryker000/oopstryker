
import java.util.*;

class email extends Exception{
    public email(String str){
        super(str);
    }
}



public class ps19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your email adress: ");
        String str = sc.nextLine();
        try {
            validatemail(str);
            System.out.println("The entered username is valid. ");
        } catch (email e) {
            System.out.println(e.getMessage());
        }
        sc.close();


    }

    public static void validatemail(String str) throws email {
        if(str == null || !str.contains("@") || !str.contains(".") ){
            throw new email("Invalid missin @ and . ");

        }
        int atind = str.indexOf('@');
        int dotind = str.indexOf('.');
        if(atind > dotind){
            throw new email("Invalide username @ should come before . ");
        }
        
        if (atind == -1 || dotind == -1 || dotind < atind || dotind == str.length() - 1) {
            throw new email("Invalid email: '@' must come before '.' and '.' must not be at the end");
        }
    }
    
}
