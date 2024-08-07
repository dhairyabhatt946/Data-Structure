import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Lab4_25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            System.out.println("Enter an element at a["+i+"]: ");
            arr[i] = sc.nextInt();
        }
        int[] newArr = removeDuplicates(arr);
        System.out.println("New array: ");
        for(int i=0; i<newArr.length; i++) {
            System.out.println("a["+i+"]: "+newArr[i]);
        }
        sc.close();
    }

    public static int[] removeDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<Integer>();
        for(int value:arr) {
            set.add(value);
        }
        int[] newArr = new int[set.size()];
        int i=0;
        for(int value:set) {
            newArr[i] = value;
            i++;
        }
        return newArr;
    }
}
