import java.util.Scanner;

public class Lab1_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter base: ");
        int x = sc.nextInt();
        System.out.println("Enter exponent: ");
        int y = sc.nextInt();
        sc.close();
        int pow = 1;
        for(int i=1; i<=y; i++) {
            pow *= x;
        }
        System.out.println(x+" raise to "+y+" is "+pow);
    }
}
