import java.util.Scanner;

public class Lab3_19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows for pascal triangle: ");
        int n = sc.nextInt();
        sc.close();
        // for(int i=0; i<n; i++) {
        //     for(int j=1; j<n-i; j++) {
        //         System.out.print(" ");
        //     }
        //     int num = 1;
        //     for(int j=0; j<=i; j++) {
        //         System.out.print(num + " ");
        //         num = num * (i-j)/(j+1);
        //     }
        //     System.out.println();
        // }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n-i; j++) {
                System.out.print(" ");
            }
            for(int j=0; j<=i; j++) {
                System.out.print(factorial(i)/(factorial(i-j)*factorial(j))+" ");
            }
            System.out.println();
        }
    }
    public static int factorial(int n) {
        int fact = 1;
        for(int i=1; i<=n; i++) {
            fact *= i;
        }
        return fact;
    }
}
