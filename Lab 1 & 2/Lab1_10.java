import java.util.Scanner;

public class Lab1_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of days: ");
        int days = sc.nextInt();
        sc.close();
        int daysInYear = 365;
        int daysInWeek = 7;
        int years = days / daysInYear;
        int remainingDays = days % daysInYear;
        int weeks = remainingDays / daysInWeek;
        int finalDays = remainingDays % daysInWeek;
        System.out.println(years+" year, "+weeks+" week and "+finalDays+" days");
    }
}
