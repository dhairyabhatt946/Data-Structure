public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 0, 2, 5, 4, 0, 2, 8, 7, 7, 9, 2, 0, 1, 9};

        int maxElement = arr[0];

        for(int i=1; i<arr.length; i++) {
            if(arr[i] > maxElement) {
                maxElement = arr[i];
            }
        }

        int[] b = countingSort(arr, maxElement);

        for(int i=0; i<b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }

    public static int[] countingSort(int[] arr, int maxElement) {
        if(arr.length == 1) return arr;

        int[] c = new int[maxElement + 1];

        for(int i=0; i<arr.length; i++) {
            c[arr[i]] = ++c[arr[i]];
        }

        for(int i=1; i<c.length; i++) {
            c[i] = c[i] + c[i-1];
        }

        int[] b = new int[arr.length];
        for(int i=arr.length - 1; i>=0; i--) {
            b[c[arr[i]]-1] = arr[i];
            c[arr[i]]--;
        }

        return b;
    }
}