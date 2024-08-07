package Lab3;

import java.util.Scanner;

public class Lab3_16 {
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
        int small=arr[0], smallIndex=0, large=arr[0], largeIndex=0;
        for(int i=0; i<n; i++) {
            if(arr[i]<small) {
                small = arr[i];
                smallIndex = i;
            }
            if(arr[i]>large) {
                large = arr[i];
                largeIndex = i;
            }
        }
        System.out.println("Position of smallest number is "+smallIndex+" and position of largest number is "+largeIndex);
    }
}
