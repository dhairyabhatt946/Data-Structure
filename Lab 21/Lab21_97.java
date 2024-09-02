public class Lab21_97 {
    public static void main(String[] args) {
        int[] arr = {42, 23, 74, 11, 65, 58, 94, 36, 99, 87};

        quick_sort(arr, 0, arr.length - 1);

        for(int temp: arr) {
            System.out.print(temp + ", ");
        }
    }

    public static void quick_sort(int[] arr, int LB, int UB) {
        boolean flag = true;
        if(LB < UB) {
            int i = LB;
            int j = UB + 1;
            int key = arr[LB];

            while(flag) {
                i++;
                while(arr[i] < key) {
                    i++;
                }
                j--;
                while(arr[j] > key) {
                    j--;
                }

                if(i < j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                else {
                    flag = false;
                }
            }
            int temp = arr[LB];
            arr[LB] = arr[j];
            arr[j] = temp;

            quick_sort(arr, LB, j-1);
            quick_sort(arr, j+1, UB);
        }
    }
}