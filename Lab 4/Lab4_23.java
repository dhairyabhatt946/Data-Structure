import java.util.Scanner;

public class Lab4_23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            System.out.println("Enter an element at a["+i+"]: ");
            arr[i] = sc.nextInt();
        }
        for(int i=0; i<n-1; i++) {
            int currentMin = arr[i];
            int currentMinIndex = i;

            for(int j=i+1; j<n; j++) {
                if(currentMin>arr[j]) {
                    currentMin = arr[j];
                    currentMinIndex = j;
                }
            }

            if(currentMinIndex!=i) {
                arr[currentMinIndex] = arr[i];
                arr[i] = currentMin;
            }
        }
        System.out.println("Sorted array: ");
        for(int i=0; i<n; i++) {
            System.out.println("a["+i+"]: "+arr[i]);
        }
        System.out.println("Enter a number to insert in the array: ");
        int num = sc.nextInt();
        int[] newArr = new int[n+1];
        int k=0;
        while(k<arr.length && arr[k]<num) {
            newArr[k] = arr[k];
            k++;
        }
        newArr[k] = num;
        while(k<arr.length) {
            newArr[k+1] = arr[k];
            k++;
        }
        System.out.println("New array: ");
        for(int i=0; i<n+1; i++) {
            System.out.println("a["+i+"]: "+newArr[i]);
        }
        sc.close();
    }
}