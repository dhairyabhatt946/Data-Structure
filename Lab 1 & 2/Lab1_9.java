import java.util.Scanner;

public class Lab1_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter seconds: ");
        int ss = sc.nextInt();
        sc.close();
        int hh=0, mm=0;
        while(ss>=60) {
            ss -= 60;
            mm++;
            if(mm>=60) {
                mm -= 60;
                hh++;
            }
        }
        System.out.println("Time in hh:mm:ss is "+hh+":"+mm+":"+ss);
    }
}
