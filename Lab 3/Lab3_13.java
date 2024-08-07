package Lab3;

import java.util.Scanner;

public class Lab3_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            System.out.println("Enter an element in arr["+i+"]: ");
            arr[i] = sc.nextInt();
        }
        sc.close();
        for(int i=0; i<n; i++) {
            System.out.println("arr["+i+"] = "+arr[i]);
        }
    }
}
