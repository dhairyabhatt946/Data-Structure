package Lab3;

import java.util.Scanner;

public class Lab3_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int m = sc.nextInt();
        System.out.println("Enter second number: ");
        int n = sc.nextInt();
        sc.close();
        int sum=0;
        for(int i=m; i<=n; i++) {
            sum += i;
        }
        System.out.println("Sum of numbers from "+m+" to "+n+" is "+sum);
    }
}
