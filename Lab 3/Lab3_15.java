package Lab3;

import java.util.Scanner;

public class Lab3_15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        sc.close();
        int sum=0;
        for(int i=1; i<=n; i++) {
            sum += i;
        }
        System.out.println("Average of first "+n+" numbers is "+((float)sum/n));
    }
}
