import java.util.Scanner;

public class Lab1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius of a circle: ");
        double radius = sc.nextDouble();
        sc.close();
        System.out.println("Area of the circle = "+(Math.PI*radius*radius));
    }
}
