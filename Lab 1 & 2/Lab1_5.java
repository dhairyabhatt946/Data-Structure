import java.util.Scanner;

public class Lab1_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        sc.close();
        int res = factorial(num);
        System.out.println("Factorial of "+num+" is "+res);
    }

    public static int factorial(int num) {
        if(num==0) {
            return 1;
        }
        else {
            return num*factorial(num-1);
        }
    }
}
