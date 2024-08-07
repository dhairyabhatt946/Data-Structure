import java.util.Scanner;

public class Lab6_36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to enter temperature in \"Fahrenhit\" or \"Celcius\"? ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Fahrenhit")) {
            System.out.println("Enter temperature in Fahrenhit: ");
            double fahrenheit = sc.nextDouble();
            double celcius = fahrenhitToCelcius(fahrenheit);
            System.out.println("Temperature in Celcius: " + celcius);
        }
        else {
            System.out.println("Enter temperature in Celcius: ");
            double celcius = sc.nextDouble();
            double fahrenheit = celciusToFahrenhit(celcius);
            System.out.println("Temperature in Fahrenhit: " + fahrenheit);
        }
        sc.close();
        scanner.close();
    }
    public static double fahrenhitToCelcius(double temperature) {
        return (temperature - 32) * 5 / 9;
    }
    public static double celciusToFahrenhit(double temperature) {
        return (temperature * 9 / 5) + 32;
    }
}
