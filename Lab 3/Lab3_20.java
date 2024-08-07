import java.util.Scanner;

public class Lab3_20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many names do you want to enter: ");
        int n = sc.nextInt();
        String[] names = new String[n];
        for(int i=0; i<n; i++) {
            System.out.println("Enter name "+i+": ");
            names[i] = sc.next();
        }
        sc.close();
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                if(names[j].compareToIgnoreCase(names[i])<0) {
                    String temp = names[j];
                    names[j] = names[i];
                    names[i] = temp;
                }
            }
        }
        System.out.println("Names in ascending order: ");
        for(int i=0; i<n; i++) {
            System.out.print(names[i]+", ");
        }
    }
}