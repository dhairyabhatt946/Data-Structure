public class Lab19_92 {
    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        
        bubble_sort(arr);
        for(int temp: arr) {
            System.out.print(temp + ", ");
        }
    }

    public static void bubble_sort(int[] arr) {
        int last = arr.length-1;
        int last_index = last;
        for(int i=0; i<last_index; i++) {
            int exchange = 0;
            for(int j=0; j<last; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    exchange++;
                }
            }
            if(exchange == 0) {
                return;
            }
            else {
                last = last-1;
            }
        }
    }
}