import java.util.Scanner;

public class Lab1_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to print series: ");
        int num = sc.nextInt();
        sc.close();
        int sum=0, rem=0;
        for(int i=1; i<=num; i++) {
            for(int j=1; j<=i; j++) {
                rem += j; 
            }
            sum += rem;
            rem = 0;
        }
        System.out.println("Sum of series: "+sum);
    }    
}
