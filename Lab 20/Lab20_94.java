public class Lab20_94 {
    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};

        selection_sort(arr);

        for(int temp: arr) {
            System.out.print(temp + ", ");
        }
    }

    public static void selection_sort(int[] arr) {

        for(int i=0; i<arr.length-1; i++) {
            int currentMin = arr[i];
            int currentMinIndex = i;

            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] < currentMin) {
                    currentMin = arr[j];
                    currentMinIndex = j;
                }
            }
            if(currentMinIndex != i) {
                arr[currentMinIndex] = arr[i];
                arr[i] = currentMin;
            }
        }
    }
}