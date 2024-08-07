import java.util.Scanner;

public class Lab4_26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of first array: ");
        int n = sc.nextInt();
        System.out.println("Enter the size of second array: ");
        int m = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for(int i=0; i<n; i++) {
            System.out.println("Enter an element at arr1["+i+"]: ");
            arr1[i] = sc.nextInt();
        }
        for(int i=0; i<m; i++) {
            System.out.println("Enter an element at arr2["+i+"]: ");
            arr2[i] = sc.nextInt();
        }
        int[] newArr = new int[arr1.length+arr2.length];
        int index=0;
        for(int i=0; i<n; i++) {
            newArr[index++] = arr1[i];
        }
        for(int i=0; i<m; i++) {
            newArr[index++] = arr2[i];
        }
        System.out.println("New merged array: ");
        for(int i=0; i<newArr.length; i++) {
            System.out.print(newArr[i]+", ");
        }
        sc.close();
    }
}
