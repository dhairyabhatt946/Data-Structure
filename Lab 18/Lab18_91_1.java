import java.util.Scanner;

public class Lab18_91_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        System.out.println("Enter an element to search in the array");
        int key = sc.nextInt();
        int index = binary_search(arr, 0, arr.length-1, key);
        if(index == -1) System.out.println("Element not found");
        else System.out.println("Element found at index "+index);
        sc.close();
    }

    public static int binary_search(int[] arr, int left, int right, int key) {
        while(left <= right) {
            int mid = (left+right)/2;

            if(arr[mid] == key) return mid;

            else if(key < arr[mid]) right = mid - 1;

            else left = mid + 1;
        }
        return -1;
    }
}
