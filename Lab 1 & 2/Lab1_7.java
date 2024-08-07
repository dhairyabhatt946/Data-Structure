import java.util.Scanner;

public class Lab1_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        sc.close();
        System.out.println("Factors of "+num+" are: ");
        for(int i=1; i<=num; i++) {
            if(num%i==0) System.out.print(i+", ");
        }        
    }    
}
