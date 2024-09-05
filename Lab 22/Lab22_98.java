public class Lab22_98 {
    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};

        heapSort(arr);

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void heapSort(int[] arr) {
        buildMaxHeap(arr);

        for(int i=arr.length-1; i>=0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    public static void buildMaxHeap(int[] arr) {
        for(int i=arr.length/2-1; i>=0; i--) {
            heapify(arr, arr.length, i);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int maxIndex = i;
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;

        if(leftChild < n && arr[leftChild] > arr[maxIndex]) {
            maxIndex = leftChild;
        }
        if(rightChild < n && arr[rightChild] > arr[maxIndex]) {
            maxIndex = rightChild;
        }
        if(i != maxIndex) {
            swap(arr, i, maxIndex);
            heapify(arr, n, maxIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
