class calculate_area{
    
    public static int area( int side){
        int ar = side*side;

        return ar;
    }

    

    public static float area(int radius , float pi){
        float ar = pi*radius*radius;

        return ar;
    }
}

public class ps5 extends calculate_area {

    public static void main(String[] args) {
        System.out.println("This is method overloading in oops");

        System.out.println("The area of an square is " + area(5));
        System.out.println("The area of an circle is " + area(5, (float) 3.14));
        
    }
}