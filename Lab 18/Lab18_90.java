import java.util.Scanner;

public class Lab18_90 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {10, 5, 83, 20, 100, 75};
        System.out.println("Enter an element to search in the array");
        int key = sc.nextInt();
        int index = linear_search(arr, key);
        if(index == -1) System.out.println("Element not found");
        else System.out.println("Element found at index "+index);
        sc.close();
    }

    public static int linear_search(int[] arr, int key) {

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
