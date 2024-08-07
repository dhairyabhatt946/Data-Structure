public class Lab19_93 {
    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        
        insertion_sort(arr);
        for(int temp: arr) {
            System.out.print(temp + ", ");
        }
    }

    public static void insertion_sort(int[] arr) {
        if(arr.length == 1) return;

        int i = 1;
        while(i < arr.length) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
            i++;
        }
    }
}
