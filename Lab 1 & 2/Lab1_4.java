import java.util.Scanner;

public class Lab1_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        sc.close();
        int res=1;
        for(int i=1; i<=num; i++) {
            res *= i;
        }
        System.out.println("Factorial of " + num + " is " + res);
    }
}
