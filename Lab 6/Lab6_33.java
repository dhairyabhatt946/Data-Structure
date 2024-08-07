import java.util.Scanner;

public class Lab6_33 {
    public static int num1, num2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number: ");
        num1 = sc.nextInt();
        System.out.println("Enter second number: ");
        num2 = sc.nextInt();
        System.out.println("Before swapping: ");
        System.out.println("Number 1: "+num1+" and Number 2: "+num2);
        swap();
        System.out.println("After swapping: ");
        System.out.println("Number 1: "+num1+" and Number 2: "+num2);
        sc.close();
    }
    public static void swap() {
        int temp = num1;
        num1 = num2;
        num2 = temp;
    }
}
