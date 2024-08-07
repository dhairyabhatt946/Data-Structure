public class Lab1_12 {
    public static void main(String[] args) {
        System.out.println("Armstrong numbers from 1 to 1000: ");
        for(int i=1; i<=1000; i++) {
            int num = i,sum=0;
            int digits = Integer.toString(num).length();
            while(num!=0) {
                int rem = num%10;
                num = num/10;
                sum += Math.pow(rem, digits);
            }
            if(sum==i) System.out.print(i+", ");
        }
    }    
}
