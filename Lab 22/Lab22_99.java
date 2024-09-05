public class Lab22_99 {
    public static void main(String[] args) {
        int[] arr = {80, 93, 60, 12, 42, 30, 68, 85, 10};

        shellSort(arr, arr.length);

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }    

    public static void shellSort(int[] arr, int n) {
        for(int gap=n/2; gap>=1; gap/=2) {
            for(int j=gap; j<n; j++) {
                for(int i=j-gap; i>=0; i-=gap) {
                    if(arr[i+gap] > arr[i]) {
                        break;
                    }
                    else {
                        swap(arr, i, i+gap);
                    }
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
