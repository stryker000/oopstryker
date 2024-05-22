import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class ps11c {
    public static String Compare(String db1,String db2){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            LocalDate d1 = LocalDate.parse(db1,formatter);
            LocalDate d2 = LocalDate.parse(db2,formatter);

            if(d1.isAfter(d2)){
                return "Younger";
            }
            else if(d1.isBefore(d2)){
                return "Elder";
            }
            else{
                return "Both have same age";
            }
        } catch (DateTimeParseException e){
            return "Dear user you have enterd invalid date format";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first dob:- ");
        String db1 = sc.nextLine();
        System.out.println("Enter the second dob:- ");
        String db2 = sc.nextLine();
        String result = Compare(db1, db2);
        System.out.println("So User1 is " + result + " than User2");
        sc.close();
        
    }
    
}
