public class Lab20_95 {
    public static void main(String[] args) {
        int[] arr = {29, 83, 471, 36, 91, 8};

        radix_sort(arr, arr.length);

        for(int temp: arr) {
            System.out.print(temp + ", ");
        }
    }

    public static void radix_sort(int[] arr, int n) {
        if(arr.length == 1) return;

        int m = getMax(arr, n);

        for(int place=1; m/place>0; place*=10) {
            countSort(arr, n, place);
        }
    }

    public static int getMax(int[] arr, int n) {
        int max = arr[0];

        for(int i=0; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static void countSort(int[] arr, int n, int place) {
        int[] output = new int[n];
        int[] count = new int[10];

        for(int i=0; i<n; i++) {
            count[(arr[i]/place)%10]++; 
        }

        for(int i=1; i<10; i++) {
            count[i] += count[i-1];
        }

        for(int i=n-1; i>=0; i--) {
            output[count[(arr[i]/place)%10]-1] = arr[i];
            count[(arr[i]/place)%10]--;
        }

        for(int i=0; i<n; i++) {
            arr[i] = output[i];
        }
    }
}