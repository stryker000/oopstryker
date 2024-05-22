import java.util.Scanner;

public class ps6{

    static final double PI = 3.14;

    static {
        System.err.println("Welcome to simple calculator!");
    }

    {
        System.err.println("New INstance of calculator");
    }

    public ps6(){}
    
    static double add(double  n,double  m){
        return n+m;
    }
    static double sub(double  n,double  m){
        return m-n;
    }
    static double mult(double  n,double  m){
        return m*n;
    }
    static double div(double  n,double  m){
        return m/n;
    }

    public static void main(String[] args) {

        ps6 ob = new ps6();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two number: ");
        double n = sc.nextInt();
        double m = sc.nextInt();
    
        System.out.println("The addition of two number is " + add(n,m));
        System.out.println("The substraction of two number is " + sub(n,m));
        System.out.println("The multiplication of two number is " + mult(n,m));
        System.out.println("The division of two number is " + div(n,m));
        }
        
}

