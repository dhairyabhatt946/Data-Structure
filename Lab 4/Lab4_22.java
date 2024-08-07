import java.util.Scanner;

public class Lab4_22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            System.out.println("Enter an element in a["+i+"]: ");
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the index from which you want to delete the number: ");
        int index = sc.nextInt();
        int[] newArr = new int[n-1];
        int oldIndex=0;
        for(int i=0; i<n-1; i++) {
            if(oldIndex == index) {
                oldIndex++;
            }
            newArr[i] = arr[oldIndex];
            oldIndex++;
        }
        System.out.println("New array: ");
        for(int i=0; i<n-1; i++) {
            System.out.println("a["+i+"]: "+newArr[i]);
        }
        sc.close();
    }
}
